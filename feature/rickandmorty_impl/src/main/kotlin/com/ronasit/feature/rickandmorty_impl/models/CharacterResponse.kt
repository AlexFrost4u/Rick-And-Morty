package com.ronasit.feature.rickandmorty_impl.models

import com.ronasit.feature.rickandmorty_api.models.Character
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val info: Info,
    val results: List<Result>
)

fun CharacterResponse.toDomain():List<Character>{
    return results.map{ result ->
        result.toDomain()
    }
}
