package com.ronasit.feature.rickandmorty_impl.model


import com.ronasit.feature.rickandmorty_api.model.EpisodePager
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResponse(
    val info: Info,
    val results: List<EpisodeResult>
)

fun EpisodeResponse.toDomain(): EpisodePager {
    return EpisodePager(episodes = results.map { item -> item.toDomain() }, countPage = info.pages)
}
