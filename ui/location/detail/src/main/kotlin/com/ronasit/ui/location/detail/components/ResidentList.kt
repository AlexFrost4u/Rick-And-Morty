package com.ronasit.ui.location.detail.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.insets.navigationBarsPadding
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.feature.rickandmorty_api.model.Character

@ExperimentalFoundationApi
@Composable
internal fun ResidentList(list: List<Character>?, onCharacterCardClick: (id: String) -> Unit) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 64.dp, top = 16.dp, start = 8.dp, end = 24.dp)
            .navigationBarsPadding()
    ) {
        if (list != null) {
            repeat(list.size) { index ->
                Card(
                    backgroundColor = RickAndMortyTheme.colors.blackCard,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        .padding(start = 16.dp, bottom = 16.dp)
                        .clickable { onCharacterCardClick(list[index].id.toString()) }
                ) {
                    ResidentItem(list[index])
                }
            }
        }
    }
}
