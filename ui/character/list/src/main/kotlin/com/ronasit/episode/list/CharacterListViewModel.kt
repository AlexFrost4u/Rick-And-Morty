package com.ronasit.episode.list

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.feature.rickandmorty_api.models.Character
import com.ronasit.feature.rickandmorty_api.usecase.GetCharacters
import kotlinx.coroutines.flow.Flow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class CharacterListViewModel(
    private val getCharacters: GetCharacters
) : ViewModel(), ContainerHost<CharacterListState, CharacterListSideEffect> {

    override val container = container<CharacterListState, CharacterListSideEffect>(CharacterListState())

    fun getCharacterPagination(): Flow<PagingData<Character>> {
        return Pager(PagingConfig(pageSize = 20)){
            CharacterSource(getCharacters)
        }.flow
    }

/*    val state = mutableStateOf(CharacterListState())*/
   /* init {

    }

    fun getCharacterList() {
        getCharacters().onEach { result ->
            when (result) {
                is DataState.Success -> {
                    state.value = CharacterListState(characters = result.data ?: emptyList())
                }
                is DataState.Error -> {
                    state.value = CharacterListState(error = (result.exception ?: "Unexpected error").toString())
                }
                is DataState.Loading -> {
                    state.value = CharacterListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }*/
}
