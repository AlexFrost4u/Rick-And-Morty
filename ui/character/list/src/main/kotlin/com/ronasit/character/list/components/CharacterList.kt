package com.ronasit.character.list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.feature.rickandmorty_api.model.Character

@ExperimentalFoundationApi
@Composable
internal fun CharacterList(characters: LazyPagingItems<Character>, onItemClick: (id: String) -> Unit) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp, start = 8.dp, end = 24.dp, top = 16.dp)
    ) {
        items(characters.itemCount) { index ->
            Card(
                backgroundColor = RickAndMortyTheme.colors.blackCard,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .defaultMinSize(minHeight = 256.dp, minWidth = 202.dp)
                    .fillMaxSize()
                    .padding(start = 16.dp, bottom = 16.dp)
                    .clickable { onItemClick(characters[index]?.id.toString()) }
            ) {
                CharacterItem(character = characters[index])
            }
        }
    }
}
