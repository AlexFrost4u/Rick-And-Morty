package com.ronasit.episode.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import com.google.accompanist.insets.statusBarsPadding
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ronasit.character.list.R
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.core.ui.theme.White
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import org.koin.androidx.compose.viewModel
import com.ronasit.feature.rickandmorty_api.domain_models.Character

@Composable
fun CharacterListScreen() {
    val viewModel:CharacterListViewModel by viewModel()
    val state = rememberCollapsingToolbarScaffoldState()
    var searchText by rememberSaveable { mutableStateOf("") }

    CollapsingToolbarScaffold(
        toolbar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(RickAndMortyTheme.colors.blackBG)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_character),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = state.toolbarState.progress,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = "Characters",
                fontFamily = RickAndMortyTheme.typography.title2.fontFamily,
                fontSize = RickAndMortyTheme.typography.title2.fontSize,
                fontStyle = RickAndMortyTheme.typography.title2.fontStyle,
                fontWeight = RickAndMortyTheme.typography.title2.fontWeight,
                color = White,
                modifier = Modifier
                    .statusBarsPadding()
                    .road(Alignment.BottomStart, Alignment.BottomStart)
                    .padding(start = 24.dp),
            )
        },
        state = state,
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        modifier = Modifier
            .fillMaxSize()
            .background(RickAndMortyTheme.colors.blackBG),
    ) {
        Column {
            SearchBar(searchText = searchText, onSearchTextChange = { searchText = it })
            CharacterList()
        }
    }
}

@Composable
fun SearchBar(searchText: String, onSearchTextChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(start = 24.dp, top = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
            .height(52.dp)
            .background(RickAndMortyTheme.colors.blackBG)
    ) {
        fun iconVisibility(): Float = if (searchText.isNotEmpty()) {
            0.0F
        } else {
            1.0F
        }

        fun iconPadding(): Int {
            return if (searchText.length < 25) {
                100 - searchText.length * 4
            } else {
                0
            }
        }
        TextField(
            value = searchText,
            onValueChange = onSearchTextChange,
            placeholder = { Text("Search", style = RickAndMortyTheme.typography.bodyDefault) },
            colors = TextFieldDefaults.textFieldColors(
                textColor = RickAndMortyTheme.colors.grayDark,
                backgroundColor = RickAndMortyTheme.colors.blackCard,
                cursorColor = RickAndMortyTheme.colors.primary,
                focusedIndicatorColor = RickAndMortyTheme.colors.primary,
                placeholderColor = RickAndMortyTheme.colors.grayDark
            ),
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_search_20),
                    contentDescription = null,
                    tint = RickAndMortyTheme.colors.grayDark,
                    modifier = Modifier
                        .padding(start = iconPadding().dp)
                        .alpha(iconVisibility())
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .padding(end = 96.dp),
            textStyle = RickAndMortyTheme.typography.bodyDefault
        )

        Image(
            painterResource(id = R.drawable.ic_sliders_24),
            contentDescription = null,
            contentScale = ContentScale.None,
            colorFilter = ColorFilter.tint(color = RickAndMortyTheme.colors.grayDark),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 24.dp)
                .clip(RoundedCornerShape(16.dp))
                .size(56.dp)
                .background(RickAndMortyTheme.colors.blackCard)
        )
    }
}

@Composable
fun CharacterList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp)
    ) {
        items(100) {
            Text(
                text = "Item $it",
                color = RickAndMortyTheme.colors.white,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

