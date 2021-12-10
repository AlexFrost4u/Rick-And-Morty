package com.ronasit.location.list.ui

import com.ronasit.feature.rickandmorty_api.model.Location

data class LocationListState(
    val locations: List<Location> = emptyList(),
    val searchText: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
)
