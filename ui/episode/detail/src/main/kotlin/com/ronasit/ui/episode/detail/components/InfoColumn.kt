package com.ronasit.ui.episode.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme


@Composable
internal fun InfoColumn(episode: String?, season: String?, airDate: String?) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            "Info",
            style = RickAndMortyTheme.typography.title5,
            color = RickAndMortyTheme.colors.white,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(136.dp)
                .background(
                    RickAndMortyTheme.colors.blackCard,
                    RoundedCornerShape(16.dp)
                )
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        "Episode:",
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.grayNormal,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        if (episode.isNullOrEmpty()) "" else episode,
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.white,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        "Season:",
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.grayNormal,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        if (season.isNullOrEmpty()) "" else season,
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.white,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        "Air Date:",
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.grayNormal,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        if (airDate.isNullOrEmpty()) "" else airDate,
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.white,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
