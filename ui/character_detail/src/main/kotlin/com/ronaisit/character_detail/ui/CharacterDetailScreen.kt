package com.ronaisit.character_detail.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.insets.statusBarsPadding
import com.ronaisit.character_detail.components.CharacterCard
import com.ronaisit.character_detail.components.CharacterInfo
import com.ronaisit.character_detail.components.CharacterOrigin
import com.ronaisit.character_detail.components.EpisodeList
import com.ronasit.character_detail.R
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.navigation.NavigationItem
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@ExperimentalFoundationApi
@Composable
fun CharacterDetailScreen(
    navController: NavController,
    id: String
) {
    val scrolls = rememberScrollState()
    val viewModel: CharacterDetailViewModel by viewModel { parametersOf(id) }
    val state = viewModel.container.stateFlow.collectAsState().value

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .height(92.dp)
                    .fillMaxWidth()
                    .background(RickAndMortyTheme.colors.blackBG)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back_24),
                    contentDescription = null,
                    tint = RickAndMortyTheme.colors.white,
                    modifier = Modifier
                        .statusBarsPadding()
                        .padding(top = 22.dp, start = 33.dp, bottom = 14.dp)
                        .clickable {
                            (navController.navigate(NavigationItem.Character.route) {
                                popUpTo(NavigationItem.Character.route)
                                launchSingleTop = true
                                restoreState = true
                            })
                        }
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(RickAndMortyTheme.colors.blackBG)
                .verticalScroll(scrolls)
        ) {
            // Bad practice to pass character object to 2 composable.Unnecessary recomposition
            CharacterCard(character = state.character)
            CharacterInfo(character = state.character)
            CharacterOrigin(origin = state.origin)
            EpisodeList(episodes = state.episodeList)
        }
    }
}
