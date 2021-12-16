package com.ronasit.location.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.location.list.R

@Composable
internal fun FilterButton(type: String, dimension: String, function: () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painterResource(id = R.drawable.ic_sliders_24),
            contentDescription = null,
            contentScale = ContentScale.None,
            colorFilter = ColorFilter.tint(color = if (type.isNotEmpty() || dimension.isNotEmpty()) RickAndMortyTheme.colors.white else RickAndMortyTheme.colors.grayDark),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clip(RoundedCornerShape(16.dp))
                .size(56.dp)
                .background(if (type.isNotEmpty() || dimension.isNotEmpty()) RickAndMortyTheme.colors.primary else RickAndMortyTheme.colors.blackCard)
                .clickable(onClick = function)
        )
    }
}
