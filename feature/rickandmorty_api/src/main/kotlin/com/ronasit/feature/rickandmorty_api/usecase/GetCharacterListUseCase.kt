package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_api.model.Character

class GetCharacterListUseCase(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke(id: String): List<Character> {
        return characterRepository.getCharacterList(id)
    }
}
