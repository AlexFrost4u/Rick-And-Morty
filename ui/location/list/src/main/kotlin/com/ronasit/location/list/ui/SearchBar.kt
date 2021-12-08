package com.ronasit.location.list.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.location.list.R

@Composable
internal fun SearchBar() {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(end = 72.dp)
    ) {
        var text by rememberSaveable { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = RickAndMortyTheme.colors.grayDark,
                backgroundColor = RickAndMortyTheme.colors.blackCard,
                cursorColor = RickAndMortyTheme.colors.primary,
                focusedIndicatorColor = RickAndMortyTheme.colors.primary,
                placeholderColor = RickAndMortyTheme.colors.grayDark
            ),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .align(alignment = Alignment.CenterStart)
                .clip(RoundedCornerShape(16.dp)),
            textStyle = RickAndMortyTheme.typography.bodyDefault
        )
        Box(
            Modifier
                .alpha(if (text.isNotEmpty()) 0f else 1f)
                .fillMaxSize()
        ) {
            Icon(
                painterResource(id = R.drawable.ic_search_24),
                contentDescription = "searchIcon",
                tint = RickAndMortyTheme.colors.grayDark,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(end = 60.dp)
            )

            Text(
                "Search",
                style = RickAndMortyTheme.typography.bodyDefault,
                color = RickAndMortyTheme.colors.grayDark,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 24.dp)
            )
        }
    }
}
