package com.ronasit.ui.location.detail.components

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
import com.ronasit.ui.location.detail.R


@Composable
internal fun ImageNameColumn(name: String?, type: String?) {
    val iconMap = mapOf(
        "Planet" to R.drawable.ic_planet_48,
        "Cluster" to R.drawable.ic_cluster_24,
        "Space station" to R.drawable.ic_space_station_24,
        "Microverse" to R.drawable.ic_microverse_24,
        "TV" to R.drawable.ic_tv,
        "Resort" to R.drawable.ic_resort_24,
        "Fantasy town" to R.drawable.ic_fantasy_town_24,
        "Dream" to R.drawable.ic_dream_24,
    )

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
                    id = iconMap.getOrDefault(
                        type,
                        android.R.drawable.stat_sys_warning
                    )
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
