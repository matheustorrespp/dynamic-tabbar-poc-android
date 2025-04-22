package com.example.featuresetupnavbar.factory

import com.example.featuresetupnavbar.factory.setups.CardDynamicTabBarFeatureSetup
import com.example.featuresetupnavbar.factory.setups.HomeDynamicTabBarFeatureSetup
import com.example.featuresetupnavbar.factory.setups.MenuDynamicTabBarFeatureSetup
import com.example.featuresetupnavbar.factory.setups.ShopDynamicTabBarFeatureSetup
import com.example.featuresetupnavbar.factory.setups.WalletDynamicTabBarFeatureSetup
import com.example.featuresetupnavbar.model.DynamicTabBarFeature
import com.example.featuresetupnavbar.model.DynamicTabBarItem

object DynamicTabBarFeatureFactory {
    fun createSetupFor(item: DynamicTabBarItem): DynamicTabBarFeatureProtocol {
        return when(item.id) {
            DynamicTabBarFeature.HOME -> HomeDynamicTabBarFeatureSetup(item)
            DynamicTabBarFeature.CARD -> CardDynamicTabBarFeatureSetup(item)
            DynamicTabBarFeature.WALLET -> WalletDynamicTabBarFeatureSetup(item)
            DynamicTabBarFeature.SHOP -> ShopDynamicTabBarFeatureSetup(item)
            DynamicTabBarFeature.MENU -> MenuDynamicTabBarFeatureSetup(item)
        }
    }
}
