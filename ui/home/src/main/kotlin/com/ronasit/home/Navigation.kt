package com.ronasit.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ronasit.episode.list.CharacterListScreen
import com.ronasit.episode.list.EpisodeListScreen
import com.ronasit.episode.list.LocationListScreen
import com.ronasit.navigation.NavigationItem

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Character.route) {

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
