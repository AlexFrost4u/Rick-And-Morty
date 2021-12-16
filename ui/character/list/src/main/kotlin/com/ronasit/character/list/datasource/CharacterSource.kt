package com.ronasit.character.list.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.orhanobut.logger.Logger
import com.ronasit.feature.rickandmorty_api.model.Character
import com.ronasit.feature.rickandmorty_api.usecase.GetCharactersUseCase

class CharacterSource(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val searchText: String,
    private val status: String,
    private val species: String,
    private val type: String,
    private val gender: String
) :
    PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val characterResponse = getCharactersUseCase(page, searchText, status, species, type, gender)

            LoadResult.Page(
                data = characterResponse.characters,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (characterResponse.countPage > page) {
                    page.plus(1)
                } else {
                    null
                }
            )
        } catch (e: Exception) {
            Logger.e(e.message ?: "CharacterSource")
            LoadResult.Error(e)
        }
    }
}
