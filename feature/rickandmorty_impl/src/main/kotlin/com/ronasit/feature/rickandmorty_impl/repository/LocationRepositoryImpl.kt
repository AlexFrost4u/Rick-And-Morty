package com.ronasit.feature.rickandmorty_impl.repository

import com.orhanobut.logger.Logger
import com.ronasit.feature.rickandmorty_api.model.Location
import com.ronasit.feature.rickandmorty_api.model.LocationPager
import com.ronasit.feature.rickandmorty_api.repository.LocationRepository
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService
import com.ronasit.feature.rickandmorty_impl.model.toDomain

class LocationRepositoryImpl(private val apiService: RickAndMortyService) : LocationRepository {
    override suspend fun getLocations(page: Int, name: String): LocationPager {
        return apiService.getAllLocations(page, name).toDomain()
    }

    override suspend fun getLocation(id: String): Location {
        Logger.e("Get Location ")
        return apiService.getLocation(id).toDomain()
    }
}
