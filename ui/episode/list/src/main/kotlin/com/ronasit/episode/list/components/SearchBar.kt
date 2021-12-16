package com.ronasit.episode.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.episode.list.R

@Composable
internal fun SearchBar(text: String, onTextChange: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(start = 24.dp, bottom = 8.dp, top = 16.dp, end = 24.dp)
            .fillMaxWidth()
            .height(52.dp)
    ) {
        TextField(
            value = text,
            onValueChange = onTextChange,
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
                .align(alignment = Alignment.Center)
                .clip(RoundedCornerShape(16.dp))
                .fillMaxSize(),
            textStyle = RickAndMortyTheme.typography.bodyDefault
        )

        Box(
            Modifier
                .alpha(if (text.isNotEmpty()) 0f else 1f)
                .fillMaxSize()
        ) {
            Icon(
                painterResource(id = R.drawable.ic_search_20),
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
