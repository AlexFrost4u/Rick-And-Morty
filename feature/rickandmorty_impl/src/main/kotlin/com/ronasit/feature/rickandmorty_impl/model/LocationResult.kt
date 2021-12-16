package com.ronasit.feature.rickandmorty_impl.model

import com.ronasit.feature.rickandmorty_api.model.Location
import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import kotlinx.serialization.Serializable
import java.net.URL
import java.nio.file.Paths

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

fun LocationResult.toDomainDetail(): LocationDetail {

    val residentIds = residents.mapNotNull { url ->
        val residentUrl = URL(url)
        val paths = Paths.get(residentUrl.path)
        paths.last()
    }

    return LocationDetail(
        id = id, name = name, type = type, dimension = dimension,
        residents = if (residentIds.size == 1) residentIds.joinToString(", ").plus(",")
        else residentIds.joinToString(", ")
    )
}
