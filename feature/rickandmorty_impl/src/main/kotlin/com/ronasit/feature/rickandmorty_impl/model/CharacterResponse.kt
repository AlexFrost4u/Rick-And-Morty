package com.ronasit.feature.rickandmorty_impl.model

import com.ronasit.feature.rickandmorty_api.model.CharacterPager
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val info: Info,
    val results: List<CharacterResult>
)

fun CharacterResponse.toDomain(): CharacterPager {
    return CharacterPager(characters = results.map { item -> item.toDomain() }, countPage = info.pages)
}
