package com.ronasit.ui.episode.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.ui.episode.detail.R


@Composable
internal fun ImageNameColumn(name: String?) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .size(150.dp)
                .background(RickAndMortyTheme.colors.blackCard, RoundedCornerShape(16.dp))
        ) {
            Icon(
                painterResource(
                    id = R.drawable.ic_play_48
                ),
                contentDescription = null,
                tint = RickAndMortyTheme.colors.white,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(50.dp)
            )
        }
        Text(
            if (name.isNullOrEmpty()) "" else name,
            style = RickAndMortyTheme.typography.title3,
            textAlign = TextAlign.Center,
            color = RickAndMortyTheme.colors.white,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
