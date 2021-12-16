package com.ronasit.episode.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme

@Composable
internal fun StickyHeaderSeason(number: String) {
    Text(
        "Season $number",
        style = RickAndMortyTheme.typography.title4,
        color = RickAndMortyTheme.colors.white,
        modifier = Modifier
            .fillMaxWidth()
            .background(RickAndMortyTheme.colors.blackBG)
            .padding(vertical = 16.dp, horizontal = 16.dp)
    )
}
