package com.ronasit.episode.list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.google.accompanist.insets.navigationBarsPadding
import com.ronasit.feature.rickandmorty_api.model.Episode

@ExperimentalFoundationApi
@Composable
internal fun EpisodeList(episodes: LazyPagingItems<Episode>, onItemClick: (id: String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .navigationBarsPadding()
            .padding(bottom = 56.dp, start = 8.dp, end = 8.dp, top = 8.dp)
    ) {
        //костыль что-бы работала пагинация
        items(episodes) {}
        episodes.itemSnapshotList.items.groupBy { it.season }.forEach { (initial, contactsForInitial) ->
            stickyHeader(initial) {
                StickyHeaderSeason(number = initial)
            }
            items(contactsForInitial.size) { item ->
                EpisodeItem(contactsForInitial[item], onEpisodeCardClick = { onItemClick(it) })
            }
        }
    }
}
