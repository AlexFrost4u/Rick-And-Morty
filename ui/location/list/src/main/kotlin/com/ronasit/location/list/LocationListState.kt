package com.ronasit.location.list

import com.ronasit.feature.rickandmorty_api.model.Location

data class LocationListState(
    val locations: List<Location> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val searchText: String = ""
)
