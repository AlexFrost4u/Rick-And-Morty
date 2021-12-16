package com.ronaisit.character_detail.ui

import androidx.lifecycle.ViewModel
import com.ronasit.feature.rickandmorty_api.usecase.GetCharacterDetailUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetEpisodeListUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetLocationUseCase
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class CharacterDetailViewModel(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    private val getLocationUseCase: GetLocationUseCase,
    private val getEpisodeListUseCase: GetEpisodeListUseCase,
    private val id: String
) : ViewModel(), ContainerHost<CharacterDetailState, CharacterDetailSideEffect> {
    override val container =
        container<CharacterDetailState, CharacterDetailSideEffect>(CharacterDetailState()) { state ->
            if (state.character == null) {
                getCharacterDetail(id)
            }
        }

    private fun getCharacterDetail(id: String) = intent {

        val character = getCharacterDetailUseCase(id)

        reduce {
            state.copy(character = character)
        }
        val episodes = getEpisodeListUseCase(character.episodes)
        reduce {
            state.copy(episodeList = episodes)
        }
        if (character.originId.isNotEmpty()) {
            val location = getLocationUseCase(character.originId)
            reduce {
                state.copy(origin = location)
            }
        }
    }
}
