package com.example.featuresetupnavbar.factory.setups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.featuresetupnavbar.R
import com.example.featuresetupnavbar.factory.DynamicTabBarBaseFeatureSetup
import com.example.featuresetupnavbar.model.DynamicTabBarItem

class WalletFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }
}

class WalletDynamicTabBarFeatureSetup(feature: DynamicTabBarItem): DynamicTabBarBaseFeatureSetup(feature) {
    override val fragment: Fragment = WalletFragment()

    override fun setup(): Fragment {
        return fragment
    }
}