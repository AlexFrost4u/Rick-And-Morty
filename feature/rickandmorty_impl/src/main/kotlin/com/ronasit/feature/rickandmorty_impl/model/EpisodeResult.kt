package com.ronasit.feature.rickandmorty_impl.model


import com.ronasit.feature.rickandmorty_api.model.Episode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EpisodeResult(
    @SerialName("air_date")
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)

fun EpisodeResult.toDomain(): Episode {
    val se = episode.replace("S", "").replace("E", " ").split(" ")
    return Episode(
        id = id,
        name = name,
        airDate = airDate,
        season = se[0].toInt().toString(),
        episode = se[1].toInt().toString()
        episode = episode
    )
}
