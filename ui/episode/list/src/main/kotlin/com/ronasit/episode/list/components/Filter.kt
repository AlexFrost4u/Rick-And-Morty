package com.ronasit.episode.list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun Filter() {
    val season = listOf("All", "Season 1", "Season 2", "Season 3", "Season 4", "Season 5")

    Row(modifier = Modifier.padding(top = 16.dp)) {
        LazyRow() {
            items(season.size) { index ->
                if (index == 0) Spacer(Modifier.padding(start = 16.dp))
                FilterItem(season[index])
            }
        }
    }
}
