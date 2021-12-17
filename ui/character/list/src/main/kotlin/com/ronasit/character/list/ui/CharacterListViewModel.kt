package com.ronasit.character.list.ui

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.character.list.CharacterFilters
import com.ronasit.character.list.Constants
import com.ronasit.character.list.datasource.CharacterSource
import com.ronasit.feature.rickandmorty_api.model.Character
import com.ronasit.feature.rickandmorty_api.usecase.GetCharactersUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

internal class CharacterListViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel(), ContainerHost<CharacterListState, CharacterListSideEffect> {
    override val container = container<CharacterListState, CharacterListSideEffect>(CharacterListState())

    @FlowPreview
    fun getCharacterPagination(): Flow<PagingData<Character>> {
        val debounce = 400L

        return Pager(PagingConfig(pageSize = Constants.pageSize)) {
            CharacterSource(
                getCharactersUseCase,
                container.stateFlow.value.searchText,
                container.stateFlow.value.status,
                container.stateFlow.value.species,
                container.stateFlow.value.type,
                container.stateFlow.value.gender
            )
        }.flow.debounce(debounce)
    }

    fun onChangeSearchText(searchText: String) = intent {
        reduce {
            state.copy(searchText = searchText)
        }
    }

    fun onFilterChanged(filter: CharacterFilters) = intent {
        reduce {
            state.copy(status = filter.status, species = filter.species, type = filter.type, gender = filter.gender)
        }
    }

}
