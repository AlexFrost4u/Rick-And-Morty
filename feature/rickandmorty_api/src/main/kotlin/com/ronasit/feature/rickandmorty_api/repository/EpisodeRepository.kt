package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodeList(id:String):List<Episode>
import com.ronasit.feature.rickandmorty_api.model.EpisodePager

interface EpisodeRepository {
    suspend fun getEpisodes(page: Int, name: String): EpisodePager
}
