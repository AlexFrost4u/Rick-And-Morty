package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.models.LocationPager

interface LocationRepository {
    suspend fun getLocations(page: Int, name: String): LocationPager
}
