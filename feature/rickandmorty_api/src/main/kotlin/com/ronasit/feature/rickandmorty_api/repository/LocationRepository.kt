package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import com.ronasit.feature.rickandmorty_api.model.LocationPager

interface LocationRepository {
    suspend fun getLocations(page: Int, name: String, type: String, dimension: String): LocationPager
    suspend fun getLocation(id: String): LocationDetail
}
