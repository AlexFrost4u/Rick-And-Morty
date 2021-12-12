package com.ronasit.feature.rickandmorty_impl.model


import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import kotlinx.serialization.Serializable

@Serializable
data class LocationDetailResponse(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)

fun LocationDetailResponse.toDomain(): LocationDetail {
    var listResidents = ""
    residents.map { item ->
        listResidents = listResidents.plus(item.replace("https://rickandmortyapi.com/api/character/", "").plus(","))
    }
    return LocationDetail(id = id, name = name, type = type, dimension = dimension, residents = listResidents)
}
