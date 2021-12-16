package com.ronasit.navigation

sealed class NavigationItem(val route: String, val icon: Int? = null, val activeIcon: Int? = null) {
    object Character : NavigationItem(
        "character_list",
        R.drawable.ic_rick_24,
        R.drawable.ic_rick_filled_24
    )

    object Location : NavigationItem(
        "location_list",
        R.drawable.ic_planet_24,
        R.drawable.ic_planet_filled_24
    )

    object Episode : NavigationItem(
        "episode_list",
        R.drawable.ic_play_24,
        R.drawable.ic_play_filled_24
    )

    object CharacterDetail : NavigationItem(
        "character_detail"
    )

    object LocationDetail : NavigationItem(
        "location_detail"
    )

    object EpisodeDetail : NavigationItem(
        "episode_detail"
    )
}
