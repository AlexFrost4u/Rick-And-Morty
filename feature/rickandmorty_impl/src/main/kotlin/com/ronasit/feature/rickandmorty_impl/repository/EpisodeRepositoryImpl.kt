package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.model.EpisodeDetail
import com.ronasit.feature.rickandmorty_api.model.EpisodePager
import com.ronasit.feature.rickandmorty_api.repository.EpisodeRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.model.toDomainDetail
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class EpisodeRepositoryImpl(private val apiService: RickAndMortyService) : EpisodeRepository {
    override suspend fun getEpisodes(page: Int, name: String, episode: String): EpisodePager {
        return apiService.getAllEpisodes(page, name, episode).toDomain()
    }

    override suspend fun getEpisode(id: String?): EpisodeDetail {
        return apiService.getEpisode(id).toDomainDetail()
    }

    override suspend fun getEpisodeList(id: String): List<Episode> {
        return apiService.getEpisodeList(id).map { result ->
            result.toDomain()
        }
    }
}
