package com.ronaisit.character_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.core.ui.utils.shortenIf
import com.ronasit.feature.rickandmorty_api.model.Episode

@Composable
fun EpisodeList(episodes: List<Episode>?, onEpisodeCardClick: (id: String) -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            "Episodes",
            style = RickAndMortyTheme.typography.title5,
            color = RickAndMortyTheme.colors.white,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp, top = 16.dp, start = 8.dp, end = 24.dp)
    ) {
        if (episodes != null) {
            repeat(episodes.size) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(96.dp)
                        .padding(start = 16.dp, bottom = 16.dp)
                        .background(RickAndMortyTheme.colors.blackCard, RoundedCornerShape(16.dp))
                        .clickable { onEpisodeCardClick(episodes[index].id.toString()) }
                ) {
                    Column(Modifier.fillMaxSize()) {
                        Row(Modifier.fillMaxWidth()) {
                            Text(
                                text = episodes[index].name.shortenIf(27),
                                style = RickAndMortyTheme.typography.title5,
                                color = RickAndMortyTheme.colors.white,
                                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                            )
                        }
                        Row(Modifier.fillMaxWidth()) {
                            Text(
                                text = "Episode: ${episodes[index].episode}, Season: ${episodes[index].season}",
                                style = RickAndMortyTheme.typography.bodySmall,
                                color = RickAndMortyTheme.colors.primary,
                                textAlign = TextAlign.Left,
                                modifier = Modifier
                                    .fillMaxWidth(0.5f)
                                    .padding(start = 16.dp, bottom = 16.dp, top = 8.dp)
                            )
                            Text(
                                text = episodes[index].airDate,
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
        }
    }
}
