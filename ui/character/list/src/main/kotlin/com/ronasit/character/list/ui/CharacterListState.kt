package com.ronasit.character.list.ui

data class CharacterListState(
    val searchText: String = "",
    val isLoading: Boolean = false,
    val error: String = "",
)
