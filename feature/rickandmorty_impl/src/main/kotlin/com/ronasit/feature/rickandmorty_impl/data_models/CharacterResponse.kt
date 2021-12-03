package com.ronasit.feature.rickandmorty_impl.data_models

import com.ronasit.feature.rickandmorty_api.domain_models.Character

data class CharacterResponse(
    val info: Info,
    val results: List<Result>
)

fun CharacterResponse.toDomain():List<Character>{
    return results.map{ result ->
        result.toDomain()
    }
}
