package com.ronasit.episode.list

import com.ronasit.feature.rickandmorty_api.models.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
