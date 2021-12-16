package com.ronaisit.character_detail.ui

import com.ronasit.feature.rickandmorty_api.model.CharacterDetail
import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.model.LocationDetail

data class CharacterDetailState(
    val character: CharacterDetail? = null,
    val episodeList: List<Episode>? = emptyList(),
    val origin: LocationDetail? = null
)
