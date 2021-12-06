package com.ronasit.feature.rickandmorty_api.repository

import com.ronasit.feature.rickandmorty_api.models.Character

interface CharacterRepository {
    suspend fun getCharacters(page:Int): List<Character>

/*    suspend fun getTestCharacters():List<Character>*/
}
