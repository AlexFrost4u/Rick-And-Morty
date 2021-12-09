package com.ronasit.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.ronasit.episode.list.CharacterListScreen
import com.ronasit.episode.list.EpisodeListScreen
import com.ronasit.location.list.LocationListScreen
import com.ronasit.navigation.NavigationItem
import kotlinx.coroutines.FlowPreview

@FlowPreview
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
            LocationListScreen()
        }

        composable(NavigationItem.Episode.route) {
            EpisodeListScreen()
        }
    }
}
