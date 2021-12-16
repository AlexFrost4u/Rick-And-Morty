package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.Location
import com.ronasit.feature.rickandmorty_api.model.LocationPager

interface LocationRepository {
    suspend fun getLocations(page: Int, name: String): LocationPager

    suspend fun getLocation(id:String): Location
}