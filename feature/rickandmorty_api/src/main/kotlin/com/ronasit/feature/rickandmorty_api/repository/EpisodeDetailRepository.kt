package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.EpisodeDetail


interface EpisodeDetailRepository {
    suspend fun getEpisodeById(id: Int?): EpisodeDetail
}
