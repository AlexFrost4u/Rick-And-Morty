package com.ronasit.ui.episode.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.ui.episode.detail.R

@Composable
internal fun TopBar(onBackButtonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .height(92.dp)
            .fillMaxWidth()
            .background(RickAndMortyTheme.colors.blackBG)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_back_24),
            contentDescription = null,
            tint = RickAndMortyTheme.colors.white,
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 22.dp, start = 33.dp, bottom = 14.dp)
                .clickable { onBackButtonClick() }
        )
    }
}
