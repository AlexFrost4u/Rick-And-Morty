package com.ronasit.episode.list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding

@ExperimentalFoundationApi
@Composable
internal fun EpisodeList() {
    val list = listOf(
        Episode("1", "1"), Episode("2", "1"), Episode("3", "1"), Episode("4", "1"),
        Episode("5", "1"), Episode("6", "1"), Episode("7", "1"), Episode("8", "1"),
        Episode("1", "2"), Episode("2", "2"), Episode("3", "2"), Episode("4", "2"),
        Episode("1", "3"), Episode("2", "3"), Episode("3", "3"), Episode("4", "3"),
        Episode("1", "4"), Episode("2", "4")
    )
LazyColumn(modifier = Modifier.navigationBarsPadding().padding(bottom = 56.dp,start=8.dp,end = 8.dp, top =16.dp)) {
    list.groupBy { it.se }.forEach { (initial, contactsForInitial) ->
            stickyHeader(initial) {
                StickyHeaderSeason(number = initial)
            }
            items(contactsForInitial) { item ->
                EpisodeItem(item.ep, item.se)
            }
        }
    }
}


data class Episode(val ep: String, val se: String)
