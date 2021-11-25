package com.ronasit.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.navigation.NavigationItem

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Character,
        NavigationItem.Location,
        NavigationItem.Episode
    )

    BottomNavigation(
        backgroundColor = RickAndMortyTheme.colors.blackCard,
        contentColor = RickAndMortyTheme.colors.white,
        elevation = 1.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { MenuItem(item, currentRoute) },
                selected = currentRoute == item.route,
                label = null,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun MenuItem(item: NavigationItem, currentRoute: String?) {
    val resourceId = if (item.route == currentRoute) {
        item.activeIcon
    } else {
        item.icon
    }

    Icon(
        painter = painterResource(id = resourceId),
        contentDescription = null
    )
}
