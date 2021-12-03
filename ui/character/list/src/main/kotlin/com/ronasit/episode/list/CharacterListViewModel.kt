package com.ronasit.episode.list

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.feature.rickandmorty_api.domain_models.Character
import com.ronasit.feature.rickandmorty_api.use_cases.GetCharacters
import kotlinx.coroutines.flow.Flow

class CharacterListViewModel(
    private val getCharacters: GetCharacters
): ViewModel() {
    fun getCharacterPagination():Flow<PagingData<Character>>{
        return Pager(PagingConfig(pageSize = 20)){
            CharacterSource(getCharacters)
        }.flow
    }
}
