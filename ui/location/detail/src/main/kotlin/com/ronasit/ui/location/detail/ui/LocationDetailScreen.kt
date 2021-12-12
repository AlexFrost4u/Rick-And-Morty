package com.ronasit.ui.location.detail.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.ui.location.detail.components.ImageNameColumn
import com.ronasit.ui.location.detail.components.InfoColumn
import com.ronasit.ui.location.detail.components.ResidentsColumn
import com.ronasit.ui.location.detail.components.TopBar
import org.koin.androidx.compose.viewModel

@ExperimentalFoundationApi
@Composable
fun LocationDetailScreen(navController: NavController, id: Int?) {
    val viewModel: LocationDetailViewModel by viewModel()
    val state = viewModel.container.stateFlow.collectAsState()
    viewModel.getLocationDetail(id!!)
    RickAndMortyTheme {
        Scaffold(
            topBar = {
                TopBar(navController = navController)
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(RickAndMortyTheme.colors.blackBG)
            ) {
                items(1) {
                    ImageNameColumn(state.value.locationDetail?.name, state.value.locationDetail?.type)
                    InfoColumn(state.value.locationDetail?.type, state.value.locationDetail?.dimension)
                    ResidentsColumn(state.value.residentList)
                }
            }
        }
    }
}
