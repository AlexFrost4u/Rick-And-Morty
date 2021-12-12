package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.LocationDetailResidentList


interface LocationDetailResidentRepository {
    suspend fun getResidentsById(id: String): LocationDetailResidentList
}
