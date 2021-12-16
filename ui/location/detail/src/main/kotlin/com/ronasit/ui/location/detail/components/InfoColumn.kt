package com.ronasit.ui.location.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ronasit.core.ui.theme.RickAndMortyTheme


@Composable
internal fun InfoColumn(type: String?, dimension: String?) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        Text(
            "Info",
            style = RickAndMortyTheme.typography.title5,
            color = RickAndMortyTheme.colors.white,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
                .background(
                    RickAndMortyTheme.colors.blackCard,
                    RoundedCornerShape(16.dp)
                )
        ) {
            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        "Type:",
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.grayNormal,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        if (type.isNullOrEmpty()) "" else type,
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.white,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp)
                ) {
                    Text(
                        "Dimension:",
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.grayNormal,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth(0.5f)
                    )
                    Text(
                        if (dimension.isNullOrEmpty()) "" else dimension,
                        style = RickAndMortyTheme.typography.bodyDefault,
                        color = RickAndMortyTheme.colors.white,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
