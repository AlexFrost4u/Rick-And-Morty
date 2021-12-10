package com.ronasit.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.ronasit.character.list.ui.CharacterListScreen
import com.ronasit.character.list.EpisodeListScreen
import com.ronasit.location.list.ui.LocationListScreen
import com.ronasit.navigation.NavigationItem
import com.ronasit.ui.location.detail.ui.LocationDetailScreen
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
internal fun Navigation(navController: NavHostController) {
    AnimatedNavHost(
        navController,
        startDestination = NavigationItem.Character.route,
        enterTransition = { fadeIn(animationSpec = tween(0)) },
        exitTransition = { fadeOut(animationSpec = tween(0)) },
        popEnterTransition = { fadeIn(animationSpec = tween(0)) },
        popExitTransition = { fadeOut(animationSpec = tween(0)) },
    ) {
        composable(NavigationItem.Character.route) {
            CharacterListScreen()
        }

        composable(NavigationItem.Location.route) {
            LocationListScreen(navController = navController)
        }

        composable(NavigationItem.Episode.route) {
            EpisodeListScreen()
        }

        composable("detail") {
            LocationDetailScreen()
        }
    }
}
