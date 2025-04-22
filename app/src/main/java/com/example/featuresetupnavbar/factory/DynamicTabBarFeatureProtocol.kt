package com.example.featuresetupnavbar.factory

import androidx.fragment.app.Fragment
import com.example.featuresetupnavbar.model.DynamicTabBarFeature
import com.example.featuresetupnavbar.model.DynamicTabBarItem

interface DynamicTabBarFeatureProtocol {
    val fragment: Fragment
    val feature: DynamicTabBarItem

    fun setup(): Fragment
    fun didSelectTab()
    fun didDeselectTab()
}

abstract class DynamicTabBarBaseFeatureSetup(override val feature: DynamicTabBarItem): DynamicTabBarFeatureProtocol {
    override fun didSelectTab() {
        //  Intentionally unimplemented
    }

    override fun didDeselectTab() {
        //  Intentionally unimplemented
    }
}