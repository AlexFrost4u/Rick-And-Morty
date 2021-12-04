package com.ronasit.episode.list

sealed class CharacterListSideEffect {
    data class NavigateToLocation(val locationId: String) : CharacterListSideEffect()
    data class NavigateToEpisode(val episodeId: String): CharacterListSideEffect()
}
