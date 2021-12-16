package com.ronasit.ui.episode.detail.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.navigation.NavigationItem
import com.ronasit.ui.episode.detail.components.ImageNameColumn
import com.ronasit.ui.episode.detail.components.InfoColumn
import com.ronasit.ui.episode.detail.components.ResidentsColumn
import com.ronasit.ui.episode.detail.components.TopBar
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@ExperimentalFoundationApi
@Composable
fun EpisodeDetailScreen(navController: NavController, id: String) {
    val viewModel: EpisodeDetailViewModel by viewModel { parametersOf(id) }
    val state = viewModel.container.stateFlow.collectAsState()
    val scroll = rememberScrollState()

    Scaffold(
        topBar = {
            TopBar(onBackButtonClick = { navController.popBackStack() })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(RickAndMortyTheme.colors.blackBG)
                .verticalScroll(scroll)
        ) {
            ImageNameColumn(state.value.episodeDetail?.name)
            InfoColumn(
                state.value.episodeDetail?.episode,
                state.value.episodeDetail?.season,
                state.value.episodeDetail?.airDate
            )
            if (state.value.characterList?.isNotEmpty() == true)
                ResidentsColumn(state.value.characterList, onItemClick = {
                    navController.navigate(NavigationItem.CharacterDetail.route.plus("/$it")) {
                        popUpTo(NavigationItem.CharacterDetail.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}
