package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.LocationDetail

interface LocationDetailRepository {
    suspend fun getLocationById(id: Int?): LocationDetail
}
