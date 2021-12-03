package com.ronasit.feature.rickandmorty_api.use_cases

import androidx.paging.PagingData
import com.ronasit.feature.rickandmorty_api.domain_models.Character
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import java.util.concurrent.Flow

class GetCharacters(
    private val characterRepository:CharacterRepository
) {
    suspend operator fun invoke(page:Int):List<Character>{
        return characterRepository.getCharacters(page)
    }
}
