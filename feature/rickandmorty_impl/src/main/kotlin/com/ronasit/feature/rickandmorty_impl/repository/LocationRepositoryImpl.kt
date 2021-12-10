package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.LocationPager
import com.ronasit.feature.rickandmorty_api.repository.LocationRepository
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService
import com.ronasit.feature.rickandmorty_impl.model.toDomain

class LocationRepositoryImpl(private val apiService: RickAndMortyService) : LocationRepository {
    override suspend fun getLocations(page: Int, name: String): LocationPager {
        return apiService.getAllLocations(page, name).toDomain()
    }
}
