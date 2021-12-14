package com.ronasit.episode.list.ui

import com.ronasit.feature.rickandmorty_api.model.Episode

data class EpisodeListState(
    val episodes: List<Episode> = emptyList(),
    val searchText: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
)
