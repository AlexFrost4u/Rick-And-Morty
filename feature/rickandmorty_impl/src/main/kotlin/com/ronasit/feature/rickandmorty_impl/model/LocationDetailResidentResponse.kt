package com.ronasit.feature.rickandmorty_impl.model


import com.ronasit.feature.rickandmorty_api.model.LocationDetailResidentList
import kotlinx.serialization.Serializable

@Serializable
data class LocationDetailResidentResponse(
    val list: ArrayList<LocationDetailResidentResponseItem>
)

fun LocationDetailResidentResponse.toDomain(): LocationDetailResidentList {
    return LocationDetailResidentList(residents = list.map { item -> item.toDomain() })
}
