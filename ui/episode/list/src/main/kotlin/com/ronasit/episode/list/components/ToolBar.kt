package com.ronasit.episode.list.components

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
import com.ronasit.core.ui.R
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.core.ui.theme.White
import me.onebone.toolbar.CollapsingToolbarScaffold
import me.onebone.toolbar.ScrollStrategy
import me.onebone.toolbar.rememberCollapsingToolbarScaffoldState

@Composable
internal fun ToolBar(body: @Composable () -> Unit) {
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
                painter = painterResource(id = R.drawable.ic_episode),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alpha = state.toolbarState.progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .pin()
            )
            Text(
                text = "Episodes",
                style = RickAndMortyTheme.typography.title2,
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
