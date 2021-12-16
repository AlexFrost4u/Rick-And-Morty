package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.EpisodePager

interface EpisodeRepository {
    suspend fun getEpisodes(page: Int, name: String): EpisodePager
}
