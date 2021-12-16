package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.Character
import com.ronasit.feature.rickandmorty_api.model.CharacterDetail
import com.ronasit.feature.rickandmorty_api.model.CharacterPager
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.model.toDomainDetail
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class CharacterRepositoryImpl(private val apiService: RickAndMortyService) : CharacterRepository {
    override suspend fun getCharacters(
        page: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String
    ): CharacterPager {
        return apiService.getAllCharacters(page, name, status, species, type, gender).toDomain()
    }

    override suspend fun getCharacter(id: String): CharacterDetail {
        return apiService.getCharacter(id).toDomainDetail()
    }

    override suspend fun getCharacterList(id: String): List<Character> {
        return apiService.getCharacterList(id).map { result ->
            result.toDomain()
        }
    }
}
