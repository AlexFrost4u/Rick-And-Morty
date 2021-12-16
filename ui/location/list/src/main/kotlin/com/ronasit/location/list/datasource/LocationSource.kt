package com.ronasit.location.list.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.orhanobut.logger.Logger
import com.ronasit.feature.rickandmorty_api.model.Location
import com.ronasit.feature.rickandmorty_api.usecase.GetLocationsUseCase

class LocationSource(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val text: String,
    private val type: String,
    private val dimension: String
) :
    PagingSource<Int, Location>() {
    override fun getRefreshKey(state: PagingState<Int, Location>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {
        return try {
            val page = params.key ?: 1
            val locationResponse = getLocationsUseCase(page, text, type, dimension)

            LoadResult.Page(
                data = locationResponse.locations,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (locationResponse.countPage > page) {
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
