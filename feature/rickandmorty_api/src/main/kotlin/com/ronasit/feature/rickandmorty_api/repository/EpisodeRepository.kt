package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.model.EpisodeDetail
import com.ronasit.feature.rickandmorty_api.model.EpisodePager

interface EpisodeRepository {
    suspend fun getEpisodeList(id: String): List<Episode>
    suspend fun getEpisodes(page: Int, name: String, episode: String): EpisodePager
    suspend fun getEpisode(id: String?): EpisodeDetail
}


