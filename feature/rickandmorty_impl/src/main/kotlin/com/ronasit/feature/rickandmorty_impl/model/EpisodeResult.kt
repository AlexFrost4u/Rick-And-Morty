package com.ronasit.feature.rickandmorty_impl.model


import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.model.EpisodeDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL
import java.nio.file.Paths

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
    )
}

fun EpisodeResult.toDomainDetail(): EpisodeDetail {
    val se = episode.replace("S", "").replace("E", " ").split(" ")

    val charactersIds = characters.mapNotNull { url ->
        val residentUrl = URL(url)
        val paths = Paths.get(residentUrl.path)

        paths.last()
    }
    return EpisodeDetail(
        id = id,
        name = name,
        airDate = airDate,
        season = se[0].toInt().toString(),
        episode = se[1].toInt().toString(),
        character = if (charactersIds.size == 1) charactersIds.joinToString(", ").plus(",")
        else charactersIds.joinToString(", ")
    )
}
