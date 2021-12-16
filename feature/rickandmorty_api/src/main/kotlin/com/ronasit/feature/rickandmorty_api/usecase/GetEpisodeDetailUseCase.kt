package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.EpisodeDetail
import com.ronasit.feature.rickandmorty_api.repository.EpisodeRepository

class GetEpisodeDetailUseCase(
    private val episodeRepository: EpisodeRepository
) {
    suspend operator fun invoke(id: String): EpisodeDetail {
        return episodeRepository.getEpisode(id)
    }
}
