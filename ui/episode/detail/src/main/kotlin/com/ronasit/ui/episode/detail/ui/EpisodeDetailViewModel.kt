package com.ronasit.ui.episode.detail.ui

import androidx.lifecycle.ViewModel
import com.ronasit.feature.rickandmorty_api.repository.EpisodeDetailRepository
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailResidentRepository
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class EpisodeDetailViewModel(
    private val episodeDetailRepository: EpisodeDetailRepository,
    private val episodeDetailResidentRepository: LocationDetailResidentRepository,
    private val id: Int
) : ViewModel(), ContainerHost<EpisodeDetailState, EpisodeDetailSideEffect> {

    override val container = container<EpisodeDetailState, EpisodeDetailSideEffect>(EpisodeDetailState()) { state ->
        if (state.episodeDetail == null) {
            getEpisodeDetail(id)
        }
    }

    private fun getEpisodeDetail(id: Int?) = intent {
        val response = episodeDetailRepository.getEpisodeById(id)
        reduce {
            state.copy(episodeDetail = response)
        }
        if (response.character.isNotEmpty()) {
            val responseResident = episodeDetailResidentRepository.getResidentsById(response.character)
            reduce {
                state.copy(characterList = responseResident)
            }
        }
    }
}
