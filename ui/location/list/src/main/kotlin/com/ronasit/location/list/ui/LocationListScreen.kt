package com.ronasit.location.list.ui

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
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.location.list.components.*
import com.ronasit.navigation.NavigationItem
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.androidx.compose.viewModel

@ExperimentalMaterialApi
@FlowPreview
@Composable
fun LocationListScreen(
    navController: NavController
) {
    val viewModel: LocationListViewModel by viewModel()
    val state = viewModel.container.stateFlow.collectAsState().value
    val locations = viewModel.getLocationPagination().collectAsLazyPagingItems()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )
    BottomSheetScaffold(
        sheetContent = {
            SheetContent(
                state.type,
                state.dimension,
                onFilterChanged = {
                    viewModel.onFiltersChanged(it)
                    coroutineScope.launch {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                })
        },
        sheetShape = RoundedCornerShape(16.dp),
        sheetBackgroundColor = Color.Transparent,
        scaffoldState = bottomSheetScaffoldState
    ) {
        ListToolBar(body = {
            Box(modifier = Modifier.background(RickAndMortyTheme.colors.blackBG)) {
                Column {
                    Box(
                        modifier = Modifier
                            .padding(start = 24.dp, bottom = 8.dp, top = 16.dp, end = 24.dp)
                            .fillMaxWidth()
                            .height(52.dp)
                    ) {
                        SearchBar(text = state.searchText, onTextChange = { viewModel.updateSearchText(it) })
                        FilterButton(state.type, state.dimension) {
                            coroutineScope.launch {
                                bottomSheetScaffoldState.bottomSheetState.expand()
                            }
                        }
                    }
                    Box(modifier = Modifier.fillMaxSize()) {
                        ListLocationItem(
                            locations,
                            onItemClick = { navController.navigate(NavigationItem.LocationDetail.route.plus("/$it")) }
                        )
                    }
                }
            }
        })
    }
}
