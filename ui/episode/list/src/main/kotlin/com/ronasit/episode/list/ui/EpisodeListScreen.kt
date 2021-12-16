package com.ronasit.episode.list.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.episode.list.components.EpisodeList
import com.ronasit.episode.list.components.Filter
import com.ronasit.episode.list.components.SearchBar
import com.ronasit.episode.list.components.ToolBar
import com.ronasit.navigation.NavigationItem
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.compose.viewModel

@FlowPreview
@ExperimentalFoundationApi
@Composable
fun EpisodeListScreen(
    navController: NavController
) {
    val viewModel: EpisodeListViewModel by viewModel()
    val state = viewModel.container.stateFlow.collectAsState().value
    val episodes = viewModel.getEpisodePagination().collectAsLazyPagingItems()

    ToolBar(body = {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(RickAndMortyTheme.colors.blackBG)
        ) {
            Column {
                SearchBar(text = state.searchText, onTextChange = { viewModel.updateSearchText(it) })
                Filter(state.episode) { viewModel.updateEpisode(it) }
                EpisodeList(
                    episodes,
                    onItemClick = { navController.navigate(NavigationItem.EpisodeDetail.route.plus("/$it")) })
            }
        }
    })
}
