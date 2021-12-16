package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.EpisodePager
import com.ronasit.feature.rickandmorty_api.repository.EpisodeRepository

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) {
    suspend operator fun invoke(page: Int, name: String, episode: String): EpisodePager {
        return episodeRepository.getEpisodes(page, name, episode)
    }
}
