package com.ronasit.episode.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.core.ui.utils.shortenIf
import com.ronasit.feature.rickandmorty_api.model.Episode

@Composable
internal fun EpisodeItem(episode: Episode, onEpisodeCardClick: (id: String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
            .background(RickAndMortyTheme.colors.blackCard, RoundedCornerShape(16.dp))
            .clickable { onEpisodeCardClick(episode.id.toString()) }
    ) {
        Column(Modifier.fillMaxSize()) {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    episode.name.shortenIf(27),
                    style = RickAndMortyTheme.typography.title5,
                    color = RickAndMortyTheme.colors.white,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                )
            }
            Row(Modifier.fillMaxWidth()) {
                Text(
                    "Episode: ${episode.episode}, Season: ${episode.season}",
                    style = RickAndMortyTheme.typography.bodySmall,
                    color = RickAndMortyTheme.colors.primary,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(start = 16.dp, bottom = 16.dp, top = 8.dp)
                )
                Text(
                    episode.airDate,
                    style = RickAndMortyTheme.typography.bodyExtraSmall,
                    color = RickAndMortyTheme.colors.grayDark,
                    textAlign = TextAlign.Right,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp, bottom = 16.dp, top = 8.dp)
                )
            }
        }
    }
}
