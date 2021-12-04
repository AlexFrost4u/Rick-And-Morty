package com.ronasit.episode.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ronasit.feature.rickandmorty_api.domain_models.Character
import com.ronasit.feature.rickandmorty_api.use_cases.GetCharacters

class CharacterSource(private val getCharacters: GetCharacters) : PagingSource<Int, Character>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val characterResponse = getCharacters(page)
            LoadResult.Page(
                data = characterResponse,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        TODO("Not yet implemented")
    }
}
