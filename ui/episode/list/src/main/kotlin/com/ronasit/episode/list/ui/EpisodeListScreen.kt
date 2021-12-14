package com.ronasit.episode.list.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.episode.list.components.EpisodeList
import com.ronasit.episode.list.components.Filter
import com.ronasit.episode.list.components.SearchBar
import com.ronasit.episode.list.components.ToolBar

@ExperimentalFoundationApi
@Preview
@Composable
fun EpisodeListScreen() {
    ToolBar(body = {
        Box(modifier = Modifier.background(RickAndMortyTheme.colors.blackBG)) {
            Column {
                SearchBar("",onTextChange = {  })
                Filter()
                EpisodeList()
            }
        }
    })
}
