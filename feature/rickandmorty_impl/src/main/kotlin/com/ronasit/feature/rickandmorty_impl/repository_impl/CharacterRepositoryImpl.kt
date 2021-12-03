package com.ronasit.feature.rickandmorty_impl.repository_impl

import com.ronasit.feature.rickandmorty_api.domain_models.Character
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_impl.data_models.toDomain
import com.ronasit.feature.rickandmorty_impl.service.RickAndMortyService

class CharacterRepositoryImpl(
    private val rickAndMortyService: RickAndMortyService
) : CharacterRepository {
    override suspend fun getCharacters(page: Int): List<Character> {
        return rickAndMortyService.getAllCharacters(page).toDomain()
    }

}
