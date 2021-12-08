package com.ronasit.location.list.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.ronasit.feature.rickandmorty_api.model.Location

@Composable
internal fun ListLocationItem(location: LazyPagingItems<Location>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp)
    ) {
        items(location) { location ->
            if (location != null) {
                Location(location)
            }
        }
    }
}
