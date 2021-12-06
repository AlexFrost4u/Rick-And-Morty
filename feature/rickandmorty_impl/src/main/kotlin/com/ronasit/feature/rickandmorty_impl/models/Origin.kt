package com.ronasit.feature.rickandmorty_impl.models

import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    val name: String,
    val url: String
)
