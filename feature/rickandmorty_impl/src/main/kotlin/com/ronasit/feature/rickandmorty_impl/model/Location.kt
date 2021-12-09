package com.ronasit.feature.rickandmorty_impl.model

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String
)
