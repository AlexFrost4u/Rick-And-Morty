package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.LocationDetailResidentList
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailResidentRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class LocationDetailResidentRepositoryImpl(private val apiService: RickAndMortyService) :
    LocationDetailResidentRepository {
    override suspend fun getResidentsById(id: String): LocationDetailResidentList {
        return apiService.getCharacterById(id = id).toDomain()
    }
}

