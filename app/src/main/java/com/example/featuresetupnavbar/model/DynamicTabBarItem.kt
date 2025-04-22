package com.example.featuresetupnavbar.model

data class DynamicTabBarItem(
    val id: DynamicTabBarFeature,
    val title: String,
    val icon: String,
    val isSelected: Boolean? = false,
    val buttonName: String,
    val businessContext: String
)

enum class DynamicTabBarFeature(val value: String) {
    HOME("HOME"),
    WALLET("WALLET"),
    CARD("CARD"),
    SHOP("SHOP"),
    MENU("MENU"),
}

class DynamicTabBarDefaultItems private constructor() {
    companion object {
        val instance = DynamicTabBarDefaultItems()
    }

    fun get(): List<DynamicTabBarItem> {
        return listOf(
            DynamicTabBarItem(
                id = DynamicTabBarFeature.HOME,
                title = "Início",
                icon = "ic_home",
                isSelected = true,
                buttonName = "TABBAR_INICIO",
                businessContext = "INICIO"
            ),
            DynamicTabBarItem(
                id = DynamicTabBarFeature.CARD,
                title = "Cartão",
                icon = "ic_card",
                buttonName = "TABBAR_CARD",
                businessContext = "INICIO"
            ),
            DynamicTabBarItem(
                id = DynamicTabBarFeature.WALLET,
                title = "Carteira",
                icon = "ic_wallet",
                buttonName = "TABBAR_CARTEIRA",
                businessContext = "INICIO"
            ),
            DynamicTabBarItem(
                id = DynamicTabBarFeature.SHOP,
                title = "Shop",
                icon = "ic_bag",
                buttonName = "TABBAR_STORE",
                businessContext = "STORE"
            ),
            DynamicTabBarItem(
                id = DynamicTabBarFeature.MENU,
                title = "Menu",
                icon = "ic_menu",
                buttonName = "TABBAR_MENU",
                businessContext = "INICIO"
            )
        )
    }
}