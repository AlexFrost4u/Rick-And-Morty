package com.ronasit.home

import androidx.compose.material.Icon
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.home.R
import com.ronasit.core.ui.theme.RickAndMortyTheme


@Composable
fun BottomNavigation() {

    val icons = listOf(
        R.drawable.ic_rick_24,
        R.drawable.ic_planet_24,
        R.drawable.ic_play_24,
    )

    var selectedIndex by remember { mutableStateOf(0) }

    BottomNavigation(
        backgroundColor = RickAndMortyTheme.colors.blackCard,
        contentColor = RickAndMortyTheme.colors.white,
        elevation = 1.dp
    ) {
        icons.forEachIndexed { index, image ->
            BottomNavigationItem(
                icon = { MenuItem(image) },
                selected = selectedIndex == index,
                label = null,
                onClick = {
                    selectedIndex = index
                }
            )
        }
    }
}

@Composable
fun MenuItem(resourceId: Int) {
    Icon(
        painter = painterResource(id = resourceId),
        contentDescription = null
    )
}

@Preview
@Composable
private fun IconBottomNavigationComponentPreview() {
    RickAndMortyTheme {
        BottomNavigation()
    }
}
