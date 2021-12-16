package com.ronasit.ui.episode.detail.ui

import com.ronasit.feature.rickandmorty_api.model.Character
import com.ronasit.feature.rickandmorty_api.model.EpisodeDetail

data class EpisodeDetailState(
    val episodeDetail: EpisodeDetail? = null,
    val characterList: List<Character>? = null
)
