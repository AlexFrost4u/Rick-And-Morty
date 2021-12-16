package com.ronasit.episode.list.ui

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.episode.list.datasource.EpisodeSource
import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.usecase.GetEpisodesUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class EpisodeListViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase
) : ViewModel(), ContainerHost<EpisodeListState, EpisodeListSideEffect> {
    override val container = container<EpisodeListState, EpisodeListSideEffect>(EpisodeListState())

    @FlowPreview
    fun getEpisodePagination(): Flow<PagingData<Episode>> {
        val debounce = 400L

        return Pager(PagingConfig(pageSize = 20)) {
            EpisodeSource(getEpisodesUseCase, container.stateFlow.value.searchText, container.stateFlow.value.episode)
        }.flow.debounce(debounce)
    }

    fun updateSearchText(text: String) = intent {
        reduce {
            state.copy(searchText = text)
        }
    }

    fun updateEpisode(text: String) = intent {
        reduce {
            state.copy(episode = text)
        }
    }
}






