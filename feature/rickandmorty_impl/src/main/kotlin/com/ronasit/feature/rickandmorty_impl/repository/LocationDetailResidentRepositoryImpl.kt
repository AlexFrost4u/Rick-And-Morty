package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.Character
import com.ronasit.feature.rickandmorty_api.model.LocationDetailResidentList
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailResidentRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService
import kotlinx.serialization.json.Json

class LocationDetailResidentRepositoryImpl(private val apiService: RickAndMortyService) :
    LocationDetailResidentRepository {
    override suspend fun getResidentsById(id: String): List<Character> {
        return  apiService.getCharacterById(id = id).map{x-> x.toDomain()}
    }
}

