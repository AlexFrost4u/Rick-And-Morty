package com.ronasit.ui.episode.detail.ui

import androidx.lifecycle.ViewModel
import com.ronasit.feature.rickandmorty_api.usecase.GetCharacterListUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetEpisodeDetailUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class EpisodeDetailViewModel(
    private val getEpisodeDetailUseCase: GetEpisodeDetailUseCase,
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val id: String
) : ViewModel(), ContainerHost<EpisodeDetailState, EpisodeDetailSideEffect> {

    override val container = container<EpisodeDetailState, EpisodeDetailSideEffect>(EpisodeDetailState()) { state ->
        if (state.episodeDetail == null) {
            getEpisodeDetail(id)
        }
    }

    private fun getEpisodeDetail(id: String) = intent {
        val episode = getEpisodeDetailUseCase(id)
        reduce {
            state.copy(episodeDetail = episode)
        }
        if (episode.character.isNotEmpty()) {
            val responseResident = getCharacterListUseCase(episode.character)
            reduce {
                state.copy(characterList = responseResident)
            }
        }
    }
}
