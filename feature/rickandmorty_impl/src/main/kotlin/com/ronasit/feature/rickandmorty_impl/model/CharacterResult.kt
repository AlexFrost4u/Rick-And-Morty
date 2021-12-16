package com.ronasit.feature.rickandmorty_impl.model

import com.ronasit.feature.rickandmorty_api.model.Character
import com.ronasit.feature.rickandmorty_api.model.CharacterDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL
import java.nio.file.Paths

@Serializable
data class CharacterResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    @SerialName("image")
    val imageUrl: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterResult.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}

fun CharacterResult.toDomainDetail(): CharacterDetail {
    val episodes = episode.mapNotNull { url ->
        val episodeUrl = URL(url)
        val paths = Paths.get(episodeUrl.path)
        paths.last()
    }
    var originTemp = ""
    if (origin.name != "unknown") {
        originTemp = originTemp.plus(origin.url.replace("https://rickandmortyapi.com/api/location/", ""))
    }
    return CharacterDetail(
        id = id,
        name = name,
        imageUrl = imageUrl,
        status = status,
        species = species,
        type = type,
        gender = gender,
        originId = originTemp,
        episodes = episodes.joinToString(", ").plus(",")
    )
}



