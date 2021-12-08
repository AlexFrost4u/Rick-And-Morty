package com.ronasit.location.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.location.list.ui.FilterButton
import com.ronasit.location.list.ui.ListToolBar
import com.ronasit.location.list.ui.Location
import com.ronasit.location.list.ui.SearchBar
import org.koin.androidx.compose.viewModel

@Composable
fun LocationListScreen() {
    val viewModel: LocationListViewModel by viewModel()
    var searchText by rememberSaveable { mutableStateOf("") }
    val locations = viewModel.getLocationPagination(searchText).collectAsLazyPagingItems()
    ListToolBar(body = {
        Box(modifier = Modifier.background(RickAndMortyTheme.colors.blackBG)) {
            Column {
                Box(
                    modifier = Modifier
                        .padding(start = 24.dp, bottom = 8.dp, top = 16.dp, end = 24.dp)
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    SearchBar(text = searchText, onTextChange = { searchText = it })
                    FilterButton()
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 56.dp)
                    ) {
                        items(locations) { location ->
                            if (location != null) {
                                Location(location)
                            }
                        }
                    }
                }
            }
        }
    })
}
