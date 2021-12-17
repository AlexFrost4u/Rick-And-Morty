package com.ronasit.navigation

sealed class NavigationItem(val route: String, val icon: Int? = null, val activeIcon: Int? = null) {
    object Character : NavigationItem(
        "character/list",
        R.drawable.ic_rick_24,
        R.drawable.ic_rick_filled_24
    )

    object Location : NavigationItem(
        "location/list",
        R.drawable.ic_planet_24,
        R.drawable.ic_planet_filled_24
    )

    object Episode : NavigationItem(
        "episode/list",
        R.drawable.ic_play_24,
        R.drawable.ic_play_filled_24
    )

    object CharacterDetail : NavigationItem(
        "character/detail"
    )

    object LocationDetail : NavigationItem(
        "location/detail"
    )

    object EpisodeDetail : NavigationItem(
        "episode/detail"
    )
}
