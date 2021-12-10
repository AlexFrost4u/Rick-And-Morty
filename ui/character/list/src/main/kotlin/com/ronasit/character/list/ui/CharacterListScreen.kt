package com.ronasit.character.list.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.character.list.components.CharacterList
import com.ronasit.character.list.components.FilterButton
import com.ronasit.character.list.components.SearchBar
import com.ronasit.character.list.components.ToolBar
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.compose.viewModel

@FlowPreview
@ExperimentalFoundationApi
@Composable
fun CharacterListScreen() {
    val viewModel: CharacterListViewModel by viewModel()
    val state = viewModel.container.stateFlow.collectAsState().value
    val characters = viewModel.getCharacterPagination().collectAsLazyPagingItems()

    ToolBar(body = {
        Box(
            modifier = Modifier
                .background(RickAndMortyTheme.colors.blackBG)
                .fillMaxSize()
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .padding(start = 24.dp, bottom = 8.dp, top = 16.dp, end = 24.dp)
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    SearchBar(searchText = state.searchText, onSearchTextChange = {
                        viewModel.onChangeSearchText(it)
                    })
                    FilterButton()
                }
                CharacterList(characters = characters)
            }
        }
    })
}







