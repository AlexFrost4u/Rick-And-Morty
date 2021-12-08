package com.ronasit.location.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.orhanobut.logger.Logger
import com.ronasit.feature.rickandmorty_api.models.Location
import com.ronasit.feature.rickandmorty_api.use_cases.GetLocations

class LocationSource(private val getLocations: GetLocations, private val text: String) : PagingSource<Int, Location>() {
    override fun getRefreshKey(state: PagingState<Int, Location>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {
        return try {
            val page = params.key ?: 1
            val locationResponse = getLocations(page, text)
            LoadResult.Page(
                data = locationResponse.location,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (locationResponse.countPage - 1 > page) {
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
