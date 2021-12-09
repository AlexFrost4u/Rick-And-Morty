package com.ronasit.feature.rickandmorty_impl.model

import com.ronasit.feature.rickandmorty_api.model.Location
import kotlinx.serialization.Serializable

@Serializable
data class LocationResult(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)

fun LocationResult.toDomain(): Location {
    return Location(
        id = id,
        name = name,
        type = type
    )
}
