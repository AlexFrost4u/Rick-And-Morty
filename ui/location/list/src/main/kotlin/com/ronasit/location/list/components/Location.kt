package com.ronasit.location.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.core.ui.utils.shortenIf
import com.ronasit.feature.rickandmorty_api.model.Location
import com.ronasit.location.list.R

@Composable
internal fun Location(location: Location, onLocationClick: (id: String) -> Unit) {
    val iconMap = mapOf(
        "Planet" to R.drawable.ic_planet_24,
        "Cluster" to R.drawable.ic_cluster_24,
        "Space station" to R.drawable.ic_space_station_24,
        "Microverse" to R.drawable.ic_microverse_24,
        "TV" to R.drawable.ic_tv,
        "Resort" to R.drawable.ic_resort_24,
        "Fantasy town" to R.drawable.ic_fantasy_town_24,
        "Dream" to R.drawable.ic_dream_24,
    )
    Box(
        Modifier
            .padding(top = 16.dp, start = 24.dp, end = 24.dp)
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = RickAndMortyTheme.colors.blackCard, shape = RoundedCornerShape(16.dp))
            .clickable { onLocationClick(location.id.toString()) }
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            Image(
                painterResource(
                    id = iconMap.getOrDefault(
                        location.type,
                        android.R.drawable.stat_sys_warning
                    )
                ),
                contentDescription = null,
                contentScale = ContentScale.None,
                colorFilter = ColorFilter.tint(color = RickAndMortyTheme.colors.grayDark),
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(64.dp)
                    .background(RickAndMortyTheme.colors.blackBG)
            )
            Column(Modifier.padding(start = 16.dp)) {
                Text(
                    location.name.shortenIf(27),
                    style = RickAndMortyTheme.typography.title5,
                    color = RickAndMortyTheme.colors.white,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    location.type,
                    style = RickAndMortyTheme.typography.bodySmall,
                    color = RickAndMortyTheme.colors.primary,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

