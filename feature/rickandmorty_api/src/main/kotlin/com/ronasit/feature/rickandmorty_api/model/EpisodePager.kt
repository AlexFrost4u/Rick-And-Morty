package com.ronasit.feature.rickandmorty_api.model

data class EpisodePager(
    val episodes: List<Episode>,
    val countPage: Int
)
