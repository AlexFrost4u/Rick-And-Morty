package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.CharacterPager

interface CharacterRepository {
    suspend fun getCharacters(page: Int, name: String): CharacterPager
}
