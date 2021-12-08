package com.ronasit.location.list

import com.ronasit.feature.rickandmorty_api.models.Location

data class LocationListState(
    val locations: List<Location> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
