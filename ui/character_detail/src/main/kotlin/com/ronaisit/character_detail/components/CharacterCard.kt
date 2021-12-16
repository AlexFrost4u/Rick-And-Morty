package com.ronaisit.character_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.feature.rickandmorty_api.model.CharacterDetail

@Composable
fun CharacterCard(character: CharacterDetail?) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        if (character != null) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
                    .size(150.dp)
                    .background(RickAndMortyTheme.colors.blackCard, RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = rememberImagePainter(character.imageUrl),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(RickAndMortyTheme.colors.blackCard)
                        .fillMaxSize()
                        .aspectRatio(1.0F)
                )
            }
            Text(
                text = character.name,
                style = RickAndMortyTheme.typography.title3,
                textAlign = TextAlign.Center,
                color = RickAndMortyTheme.colors.white,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = character.status,
                style = RickAndMortyTheme.typography.bodyDefault,
                textAlign = TextAlign.Center,
                color = RickAndMortyTheme.colors.primary,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
