package com.ronasit.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ronasit.core.ui.theme.RickAndMortyTheme
import kotlinx.coroutines.FlowPreview

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@FlowPreview
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

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@FlowPreview
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
@Suppress("detekt.UnusedPrivateMember")
private fun MainContainerPreview() {
    MainContainer()
}
