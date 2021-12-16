package com.ronasit.episode.list.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.orhanobut.logger.Logger
import com.ronasit.feature.rickandmorty_api.model.Episode
import com.ronasit.feature.rickandmorty_api.usecase.GetEpisodesUseCase

class EpisodeSource(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    private val text: String,
    private val episode: String
) :
    PagingSource<Int, Episode>() {

    override fun getRefreshKey(state: PagingState<Int, Episode>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
        return try {
            val page = params.key ?: 1
            val episodeResponse = getEpisodesUseCase(page, text, episode)

            LoadResult.Page(
                data = episodeResponse.episodes,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (episodeResponse.countPage > page) {
                    page.plus(1)
                } else {
                    null
                }
            )
        } catch (e: Exception) {
            Logger.e(e.message ?: "LocationSource")
            LoadResult.Error(e)
        }
    }
}
