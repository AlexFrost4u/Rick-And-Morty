package com.ronasit.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.compose.animation.ExperimentalAnimationApi
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.home.MainContainer

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SplashScreen)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false);
        setContent {
            RickAndMortyTheme {
                MainContainer()
            }
        }
    }
}
