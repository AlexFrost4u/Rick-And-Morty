package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class LocationDetailRepositoryImpl(private val apiService: RickAndMortyService) : LocationDetailRepository {
    override suspend fun getLocationById(id: Int?): LocationDetail {
        return apiService.getLocationById(id = id).toDomain()
    }
}
