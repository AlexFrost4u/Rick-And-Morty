package com.ronasit.feature.rickandmorty_impl.model

import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import com.ronasit.feature.rickandmorty_api.model.LocationPager
import kotlinx.serialization.Serializable
import java.net.URL
import java.nio.file.Paths

@Serializable
data class LocationResponse(
    val info: Info,
    val results: List<LocationResult>
)

fun LocationResponse.toDomain(): LocationPager {
    return LocationPager(locations = results.map { item -> item.toDomain() }, countPage = info.pages)
}


