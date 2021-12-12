package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.Character

interface LocationDetailResidentRepository {
    suspend fun getResidentsById(id: String): List<Character>
}
