package com.ronasit.location.list

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ronasit.feature.rickandmorty_api.model.Location
import com.ronasit.feature.rickandmorty_api.use_cases.GetLocations
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.debounce
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container

class LocationListViewModel(
    private val getLocations: GetLocations
) : ViewModel(), ContainerHost<LocationListState, LocationListSideEffect> {

    override val container = container<LocationListState, LocationListSideEffect>(LocationListState())

    @FlowPreview
    fun getLocationPagination(): Flow<PagingData<Location>> {
        val debounce = 400L

        return Pager(PagingConfig(pageSize = 20)) {
            LocationSource(getLocations, container.stateFlow.value.searchText)
        }.flow.debounce(debounce)
    }

    fun updateSearchText(text: String) = intent {
        reduce {
            state.copy(searchText = text)
        }
    }
}
