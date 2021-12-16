package com.ronasit.feature.rickandmorty_api.usecase

import com.ronasit.feature.rickandmorty_api.model.CharacterDetail
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository

class GetCharacterDetailUseCase(
    private val characterRepository: CharacterRepository,
) {
    suspend operator fun invoke(id: String): CharacterDetail {
        return characterRepository.getCharacter(id)
    }
}
