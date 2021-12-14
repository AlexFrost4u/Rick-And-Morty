package com.ronasit.episode.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme

@Composable
internal fun Filter() {
    Row(modifier =Modifier.padding(top=16.dp)) {
        LazyRow() {
            items(10) { index ->
                if(index == 0) Spacer(Modifier.padding(start = 16.dp))
                FilterItem(text = "Season 1")
            }
        }
    }
}
