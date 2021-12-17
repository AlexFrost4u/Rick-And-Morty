package com.ronasit.character.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.orhanobut.logger.Logger
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.feature.rickandmorty_api.model.Character

@Composable
internal fun CharacterItem(character: Character?) {
    if (character != null) {
    }
    Column {
        Image(
            painter = rememberImagePainter(character!!.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(RickAndMortyTheme.colors.blackCard)
                .fillMaxSize()
                .aspectRatio(1.0F)
        )
        Text(
            text = character.name,
            color = RickAndMortyTheme.colors.white,
            textAlign = TextAlign.Center,
            style = RickAndMortyTheme.typography.title5,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}
