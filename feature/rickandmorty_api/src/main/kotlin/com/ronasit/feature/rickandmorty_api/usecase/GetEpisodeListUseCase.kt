package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.repository.EpisodeRepository

class GetEpisodeListUseCase(
    private val episodeRepository: EpisodeRepository
) {
    suspend operator fun invoke(id: String): List<Episode> {
        return episodeRepository.getEpisodeList(id)
    }
}
