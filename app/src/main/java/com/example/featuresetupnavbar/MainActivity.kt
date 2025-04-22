package com.example.featuresetupnavbar

import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainer
import com.example.featuresetupnavbar.factory.DynamicTabBarFeatureFactory
import com.example.featuresetupnavbar.factory.DynamicTabBarFeatureProtocol
import com.example.featuresetupnavbar.model.DynamicTabBarDefaultItems
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var fragmentContainer: FrameLayout

    private val featureSetups = mutableListOf<DynamicTabBarFeatureProtocol>()
    private var previousIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        fragmentContainer = findViewById(R.id.fragmentContainer)
        setupDynamicTabs()
    }

    private fun setupDynamicTabs() {
        val tabFeatures = DynamicTabBarDefaultItems.instance.get()

        featureSetups.clear()
        featureSetups.addAll(tabFeatures.map { DynamicTabBarFeatureFactory.createSetupFor(it) })

        bottomNavigationView.menu.clear()
        featureSetups.forEachIndexed { index, setup ->
            val menuItem = bottomNavigationView.menu.add(Menu.NONE, index, index, setup.feature.title)
            val icon = resources.getIdentifier(setup.feature.icon, "drawable", packageName)
            menuItem.setIcon(icon)
        }

        val selectedTabIndex = featureSetups.indexOfFirst { it.feature.isSelected == true }
        if (selectedTabIndex != -1) {
            bottomNavigationView.selectedItemId = selectedTabIndex
            previousIndex = selectedTabIndex
            showFragmentForTab(selectedTabIndex, featureSetups)
        } else if (featureSetups.isNotEmpty()) {
            bottomNavigationView.selectedItemId = 0
            showFragmentForTab(0, featureSetups)
        }

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            val tabIndex = menuItem.itemId

            if (previousIndex < featureSetups.size) {
                featureSetups[previousIndex].didDeselectTab()
            }

            if (tabIndex < featureSetups.size) {
                featureSetups[tabIndex].didSelectTab()

                val feature = featureSetups[tabIndex].feature
                trackTabSelected(feature.buttonName, feature.businessContext)
                showFragmentForTab(tabIndex, featureSetups)
            }
            previousIndex = tabIndex
            true
        }
    }

    private fun showFragmentForTab(tabIndex: Int, setups: List<DynamicTabBarFeatureProtocol>) {
        val fragment = setups[tabIndex].setup()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

    private fun trackTabSelected(buttonName: String, businessName: String) {
        // track
    }
}