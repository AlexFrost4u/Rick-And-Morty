package com.ronasit.episode.list

import android.util.Log
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.statusBarsPadding
import com.ronasit.character.list.R
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.core.ui.theme.White
import com.ronasit.feature.rickandmorty_api.domain_models.Character
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState
import org.koin.androidx.compose.viewModel

@Composable
fun CharacterListScreen() {
    val viewModel: CharacterListViewModel by viewModel()
    val state = rememberCollapsingToolbarScaffoldState()
    var searchText by rememberSaveable { mutableStateOf("") }
    val characters = viewModel.getCharacterPagination().collectAsLazyPagingItems()
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 56.dp)
            ) {
                items(characters) { character ->
                    Log.i("QWERTY","${character!!.name} and ${character.imageUrl}")
                    Card(
                        backgroundColor = RickAndMortyTheme.colors.blackCard,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .defaultMinSize(minHeight = 256.dp, minWidth = 202.dp)
                            .fillMaxSize()
                            .padding(start = 16.dp, bottom = 16.dp)
                    ) {
                        Column() {
                            Image(
                                painter = rememberImagePainter(character.imageUrl),
                                contentDescription = null,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
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


                }
            }

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





