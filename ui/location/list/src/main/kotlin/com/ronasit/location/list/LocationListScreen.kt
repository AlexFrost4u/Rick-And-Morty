package com.ronasit.location.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.location.list.ui.FilterButton
import com.ronasit.location.list.ui.ListLocationItem
import com.ronasit.location.list.ui.ListToolBar
import com.ronasit.location.list.ui.SearchBar
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.compose.viewModel

@FlowPreview
@Composable
fun LocationListScreen() {
    val viewModel: LocationListViewModel by viewModel()
    val state = viewModel.container.stateFlow.collectAsState().value
    val location = viewModel.getLocationPagination().collectAsLazyPagingItems()

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
                    FilterButton()
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    ListLocationItem(location)
                }
            }
        }
    })
}
