package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.models.Character
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_impl.models.toDomain
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService
import timber.log.Timber

class CharacterRepositoryImpl(
    private val rickAndMortyService: RickAndMortyService
) : CharacterRepository {
    override suspend fun getCharacters(page: Int): List<Character> {
        Timber.i("Repository")
        return rickAndMortyService.getAllCharacters(page).toDomain()
    }
/*
    override suspend fun getTestCharacters(): List<Character> {
        return rickAndMortyService.getTestCharacters().toDomain()
    }*/

}
