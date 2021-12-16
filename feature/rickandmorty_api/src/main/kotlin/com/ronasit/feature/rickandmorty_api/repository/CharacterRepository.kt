package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.model.Character
import com.ronasit.feature.rickandmorty_api.model.CharacterDetail
import com.ronasit.feature.rickandmorty_api.model.CharacterPager

interface CharacterRepository {
    suspend fun getCharacters(
        page: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String
    ): CharacterPager

    suspend fun getCharacter(id: String): CharacterDetail
    suspend fun getCharacterList(id: String): List<Character>
}
