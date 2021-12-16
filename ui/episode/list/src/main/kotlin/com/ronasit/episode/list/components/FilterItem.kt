package com.ronasit.episode.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme

@Composable
internal fun FilterItem(text: Pair<String, String>, onEpisodeChange: (String) -> Unit, episode: String) {
    Box(
        Modifier
            .padding(horizontal = 8.dp)
            .background(RickAndMortyTheme.colors.blackCard, RoundedCornerShape(16.dp))
            .clickable(onClick = { onEpisodeChange(text.second) })
    ) {
        Text(
            text.first,
            color = if (episode == text.second) RickAndMortyTheme.colors.white else RickAndMortyTheme.colors.grayDark,
            style = RickAndMortyTheme.typography.bodyDefault,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}
