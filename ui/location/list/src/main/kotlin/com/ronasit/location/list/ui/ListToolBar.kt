package com.ronasit.location.list.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.core.ui.theme.White
import com.ronasit.location.list.R
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
fun ListToolBar(body: @Composable () -> Unit) {
    val state = rememberCollapsingToolbarScaffoldState()
    CollapsingToolbarScaffold(
        toolbar = {
            Box(
                modifier = Modifier
                    .background(RickAndMortyTheme.colors.blackBG)
                    .fillMaxWidth()
                    .height(250.dp)
                    .pin()
            )
            Image(
                painter = painterResource(id = R.drawable.image_location),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = state.toolbarState.progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .pin()
            )
            Text(
                text = "Locations",
                fontFamily = RickAndMortyTheme.typography.title2.fontFamily,
                fontSize = RickAndMortyTheme.typography.title2.fontSize,
                fontStyle = RickAndMortyTheme.typography.title2.fontStyle,
                fontWeight = RickAndMortyTheme.typography.title2.fontWeight,
                color = White,
                modifier = Modifier
                    .road(Alignment.BottomStart, Alignment.BottomStart)
                    .statusBarsPadding()
                    .padding(start = 24.dp),
            )
        },
        state = state,
        modifier = Modifier.fillMaxSize(),
        scrollStrategy = ScrollStrategy.ExitUntilCollapsed,
        body = body
    )
}
