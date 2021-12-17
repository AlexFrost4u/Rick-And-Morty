package com.ronasit.character.list.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.ronasit.character.list.components.*
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.navigation.NavigationItem
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.androidx.compose.viewModel


@ExperimentalMaterialApi
@FlowPreview
@ExperimentalFoundationApi
@Composable
fun CharacterListScreen(
    navController: NavController
) {
    val viewModel: CharacterListViewModel by viewModel()
    val state = viewModel.container.stateFlow.collectAsState().value
    val characters = viewModel.getCharacterPagination().collectAsLazyPagingItems()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )

    BottomSheetScaffold(
        sheetContent = {
            SheetContent(
                state.status,
                state.species,
                state.type,
                state.gender,
                onFilterChanged = {
                    viewModel.onFilterChanged(it)
                    coroutineScope.launch {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            )
        },
        sheetShape = RoundedCornerShape(16.dp),
        sheetBackgroundColor = Color.Transparent,
        scaffoldState = bottomSheetScaffoldState
    ) {
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
                        FilterButton(state.status, state.species, state.type, state.gender) {
                            coroutineScope.launch {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            }
                        }
                    }
                    CharacterList(
                        characters = characters,
                        onItemClick = { navController.navigate(NavigationItem.CharacterDetail.route.plus("/$it")) }
                    )
                }
            }
        })
    }
}







