package com.ronasit.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.ronasit.core.ui.theme.RickAndMortyTheme

@Composable
fun MainContainer() {
    ProvideWindowInsets {
        RickAndMortyTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = RickAndMortyTheme.colors.blackBG
            ) {

            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickAndMortyTheme {
        Greeting("Android")
    }
}
