package com.ronasit.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ronasit.core.ui.theme.RickAndMortyTheme

@ExperimentalAnimationApi
@Composable
fun MainContainer() {
        val navController = rememberAnimatedNavController()
        ProvideWindowInsets {
            RickAndMortyTheme {
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) {
                    Navigation(navController = navController)
                }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
@Suppress
private fun MainContainerPreview() {
    MainContainer()
}
