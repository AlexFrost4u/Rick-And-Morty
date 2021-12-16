package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.CharacterPager
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository

class GetCharactersUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(
        page: Int,
        name: String,
        status: String,
        species: String,
        type: String,
        gender: String
    ): CharacterPager {
        return characterRepository.getCharacters(page, name, status, species, type, gender)
    }
}
