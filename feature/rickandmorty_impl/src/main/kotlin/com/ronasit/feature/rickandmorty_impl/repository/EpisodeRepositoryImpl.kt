package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.EpisodePager
import com.orhanobut.logger.Logger
import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.repository.EpisodeRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class EpisodeRepositoryImpl(private val apiService: RickAndMortyService) : EpisodeRepository {
    override suspend fun getEpisodes(page: Int, name: String): EpisodePager {
        return apiService.getAllEpisodes(page, name).toDomain()
class EpisodeRepositoryImpl(private val apiService: RickAndMortyService):EpisodeRepository  {
    override suspend fun getEpisodeList(id: String): List<Episode> {
        Logger.e("Get Episode List")
       return apiService.getEpisodeList(id).map { result ->
            result.toDomain()
        }
    }
}
