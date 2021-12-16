package com.ronasit.episode.list.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ronasit.episode.list.Filter.season

@Composable
internal fun Filter(episode: String, onEpisodeChange: (String) -> Unit) {
    Row(modifier = Modifier.padding(top = 16.dp)) {
        LazyRow() {
            items(season.size) { index ->
                if (index == 0) Spacer(Modifier.padding(start = 16.dp))
                FilterItem(season[index], onEpisodeChange, episode)
            }
        }
    }
}
