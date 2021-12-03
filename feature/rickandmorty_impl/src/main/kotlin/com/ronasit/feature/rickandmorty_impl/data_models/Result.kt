package com.ronasit.feature.rickandmorty_impl.data_models

import com.ronasit.feature.rickandmorty_api.domain_models.Character
import com.squareup.moshi.Json

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    @Json(name = "image")
    val imageUrl: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Result.toDomain():Character{
    return Character(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}



