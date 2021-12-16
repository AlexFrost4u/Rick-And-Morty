package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.LocationDetail
import com.ronasit.feature.rickandmorty_api.model.LocationPager
import com.ronasit.feature.rickandmorty_api.repository.LocationRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.model.toDomainDetail
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class LocationRepositoryImpl(private val apiService: RickAndMortyService) : LocationRepository {
    override suspend fun getLocations(page: Int, name: String, type: String, dimension: String): LocationPager {
        return apiService.getAllLocations(page, name, type, dimension).toDomain()
    }

    override suspend fun getLocation(id: String): LocationDetail {
        return apiService.getLocation(id).toDomainDetail()
    }
}
