package com.ronasit.feature.rickandmorty_api.model

data class CharacterDetail(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originId: String,
    val episodes: String,
)
