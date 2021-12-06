package com.ronasit.feature.rickandmorty_impl.models

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val name: String,
    val url: String
)
