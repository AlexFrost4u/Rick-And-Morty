package com.ronasit.location.list

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.feature.rickandmorty_api.models.Location
import com.ronasit.feature.rickandmorty_api.use_cases.GetLocations
import kotlinx.coroutines.flow.Flow
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container

class LocationListViewModel(
    private val getLocations: GetLocations
) : ViewModel(), ContainerHost<LocationListState, LocationListSideEffect> {

    override val container = container<LocationListState, LocationListSideEffect>(LocationListState())

    fun getLocationPagination(text: String): Flow<PagingData<Location>> {
        return Pager(PagingConfig(pageSize = 20)) {
            LocationSource(getLocations, text)
        }.flow
    }
}

