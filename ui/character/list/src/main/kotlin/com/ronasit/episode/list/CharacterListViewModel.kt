package com.ronasit.episode.list

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.feature.rickandmorty_api.domain_models.Character
import com.ronasit.feature.rickandmorty_api.use_cases.GetCharacters
import kotlinx.coroutines.flow.Flow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class CharacterListViewModel(
    private val getCharacters: GetCharacters
): ViewModel(), ContainerHost<CharacterListState,CharacterListSideEffect> {

    override val container =  container<CharacterListState, CharacterListSideEffect>(CharacterListState())

    fun getCharacterPagination(): Flow<PagingData<Character>> {
        return Pager(PagingConfig(pageSize = 20)){
            CharacterSource(getCharacters)
        }.flow
    }
    
}
