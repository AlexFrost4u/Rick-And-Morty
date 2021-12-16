package com.ronasit.location.list.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.insets.navigationBarsPadding
import com.ronasit.feature.rickandmorty_api.model.Location

@Composable
internal fun ListLocationItem(locations: LazyPagingItems<Location>, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 64.dp)
            .navigationBarsPadding()
    ) {
        items(locations) { item ->
            if (item != null) {
                Location(item, navController = navController)
            }
        }
    }
}
