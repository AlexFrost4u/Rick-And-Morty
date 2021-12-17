package com.ronasit.location.list.ui

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.feature.rickandmorty_api.model.Location
import com.ronasit.feature.rickandmorty_api.usecase.GetLocationsUseCase
import com.ronasit.location.list.LocationFilters
import com.ronasit.location.list.datasource.LocationSource
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class LocationListViewModel(
    private val getLocationsUseCase: GetLocationsUseCase
) : ViewModel(), ContainerHost<LocationListState, LocationListSideEffect> {

    override val container = container<LocationListState, LocationListSideEffect>(LocationListState())

    @FlowPreview
    fun getLocationPagination(): Flow<PagingData<Location>> {
        val debounce = 400L

        return Pager(PagingConfig(pageSize = 20)) {
            LocationSource(
                getLocationsUseCase,
                container.stateFlow.value.searchText,
                container.stateFlow.value.type,
                container.stateFlow.value.dimension
            )
        }.flow.debounce(debounce)
    }

    fun updateSearchText(text: String) = intent {
        reduce {
            state.copy(searchText = text)
        }
    }

    fun onFiltersChanged(filter:LocationFilters) = intent{
        reduce {
            state.copy(type = filter.type, dimension = filter.dimension)
        }
    }
}
