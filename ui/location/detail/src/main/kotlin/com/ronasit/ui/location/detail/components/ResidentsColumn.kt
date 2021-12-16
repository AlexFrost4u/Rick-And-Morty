package com.ronasit.ui.location.detail.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.feature.rickandmorty_api.model.Character


@ExperimentalFoundationApi
@Composable
internal fun ResidentsColumn(list: List<Character>?, onItemClick: (id: String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            "Residents",
            style = RickAndMortyTheme.typography.title5,
            color = RickAndMortyTheme.colors.white,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
    ResidentList(list, onCharacterCardClick = { onItemClick(it) })
}
