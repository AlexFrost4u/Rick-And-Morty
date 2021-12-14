package com.ronasit.feature.rickandmorty_impl.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    val info: Info,
    val results: List<EpisodeResult>
)
