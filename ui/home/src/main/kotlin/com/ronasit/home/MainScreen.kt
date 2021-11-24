package com.ronasit.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ronasit.core.ui.theme.RickAndMortyTheme

@Composable
fun MainContainer() {
    val navController = rememberNavController()
    RickAndMortyTheme {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) }
        ) {
            Navigation(navController)
        }
    }
}

@Preview(showBackground = true)
@Composable
@Suppress
private fun DefaultPreview() {
    MainContainer()
}
