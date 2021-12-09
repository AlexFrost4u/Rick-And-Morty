package com.ronasit.feature.rickandmorty_impl.repository

import com.ronasit.feature.rickandmorty_api.model.CharacterPager
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_impl.model.toDomain
import com.ronasit.feature.rickandmorty_impl.network.RickAndMortyService

class CharacterRepositoryImpl(
    private val rickAndMortyService: RickAndMortyService
) : CharacterRepository {
    override suspend fun getCharacters(page: Int,name:String): CharacterPager {
        return rickAndMortyService.getAllCharacters(page,name).toDomain()
    }
}
