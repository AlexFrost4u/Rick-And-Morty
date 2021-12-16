package com.ronasit.feature.rickandmorty_api.model

data class EpisodeDetail(
    val id: Int,
    val name: String,
    val episode: String,
    val season: String,
    val airDate: String,
    val character: String
)
