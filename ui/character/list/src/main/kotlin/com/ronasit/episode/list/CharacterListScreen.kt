package com.ronasit.episode.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ronasit.core.ui.theme.RickAndMortyTheme

@Composable
fun CharacterListScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RickAndMortyTheme.colors.blackBG)
    ) {
        Text(
            text = "Character List Screen",
            color = RickAndMortyTheme.colors.white
        )
    }
}
