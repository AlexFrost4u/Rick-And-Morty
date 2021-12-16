package com.ronasit.ui.location.detail.ui

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
import com.ronasit.ui.location.detail.components.ImageNameColumn
import com.ronasit.ui.location.detail.components.InfoColumn
import com.ronasit.ui.location.detail.components.ResidentsColumn
import com.ronasit.ui.location.detail.components.TopBar
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@ExperimentalFoundationApi
@Composable
fun LocationDetailScreen(navController: NavController, id: String) {
    val viewModel: LocationDetailViewModel by viewModel { parametersOf(id) }
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
            ImageNameColumn(state.value.locationDetail?.name, state.value.locationDetail?.type)
            InfoColumn(state.value.locationDetail?.type, state.value.locationDetail?.dimension)

            if (state.value.residentList?.isNotEmpty() == true)
                ResidentsColumn(state.value.residentList, onItemClick = {
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
