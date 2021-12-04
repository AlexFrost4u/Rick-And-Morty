package com.ronasit.episode.list

import com.ronasit.feature.rickandmorty_api.domain_models.Character

data class CharacterListState(
    val characters: List<Character> = emptyList()
)
