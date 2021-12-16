package com.ronasit.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.ronaisit.character_detail.ui.CharacterDetailScreen
import com.ronasit.character.list.ui.CharacterListScreen
import com.ronasit.episode.list.ui.EpisodeListScreen
import com.ronasit.location.list.ui.LocationListScreen
import com.ronasit.navigation.NavigationItem
import com.ronasit.ui.episode.detail.ui.EpisodeDetailScreen
import com.ronasit.ui.location.detail.ui.LocationDetailScreen
import kotlinx.coroutines.FlowPreview

@ExperimentalMaterialApi
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
            CharacterListScreen(navController = navController)
        }

        composable(NavigationItem.Location.route) {
            LocationListScreen(navController = navController)
        }

        composable(NavigationItem.Episode.route) {
            EpisodeListScreen(navController = navController)
        }

        composable(
            NavigationItem.CharacterDetail.route.plus("/{id}"),
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("id")?.let { CharacterDetailScreen(navController, it) }
        }

        composable(
            NavigationItem.LocationDetail.route.plus("/{id}"),
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("id")?.let { LocationDetailScreen(navController, it) }
        }

        composable(
            NavigationItem.EpisodeDetail.route.plus("/{id}"),
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("id")?.let { EpisodeDetailScreen(navController, it) }
        }
    }
}
