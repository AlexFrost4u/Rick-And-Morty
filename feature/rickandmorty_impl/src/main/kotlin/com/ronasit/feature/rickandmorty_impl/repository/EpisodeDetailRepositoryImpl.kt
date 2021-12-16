package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.EpisodeDetail
import com.ronasit.feature.rickandmorty_api.repository.EpisodeDetailRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class EpisodeDetailRepositoryImpl(private val apiService: RickAndMortyService) : EpisodeDetailRepository {
    override suspend fun getEpisodeById(id: Int?): EpisodeDetail {
        return apiService.getEpisodeById(id = id).toDomain()
    }
}

