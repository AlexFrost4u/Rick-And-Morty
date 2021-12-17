package com.ronasit.location.list.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.insets.navigationBarsPadding
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.location.list.Filter.locationDimension
import com.ronasit.location.list.Filter.locationType
import com.ronasit.location.list.LocationFilters
import com.ronasit.location.list.R

@Composable
internal fun SheetContent(
    type: String,
    dimension: String,
    onFilterChanged: (LocationFilters) -> Unit
) {
    val scroll = rememberScrollState()
    var localType by rememberSaveable { mutableStateOf("") }
    var localDimension by rememberSaveable { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxSize()
            .padding(top = 60.dp)
            .background(RickAndMortyTheme.colors.blackCard)
    ) {
        Column(modifier = Modifier.verticalScroll(scroll)) {
            Image(
                painter = painterResource(id = R.drawable.ic_line), contentDescription = null, modifier = Modifier
                    .fillMaxWidth()
                    .align(
                        Alignment.CenterHorizontally
                    )
                    .padding(top = 16.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 24.dp, end = 24.dp, bottom = 24.dp)
            ) {
                Text(
                    "Filters",
                    style = RickAndMortyTheme.typography.title4,
                    color = RickAndMortyTheme.colors.white,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxWidth(0.5f)
                )
                Text(
                    "Reset All", style = RickAndMortyTheme.typography.title5,
                    color = RickAndMortyTheme.colors.grayDark,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            localType = ""
                            localDimension = ""
                        }
                )
            }

            FilterSection(name = "Type", list = locationType, filter = localType) {
                localType = it
            }
            FilterSection(name = "Dimension", list = locationDimension, filter = localDimension) {
                localDimension = it
            }

            Spacer(
                Modifier
                    .padding(bottom = 116.dp)
                    .navigationBarsPadding()
            )
        }
        Button(
            onClick = {
                onFilterChanged(
                    LocationFilters(
                        type = localType,
                        dimension = localDimension
                    )
                )
            },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (localType == type && localDimension == dimension) Color(
                    0xFF3C3F4C
                ) else RickAndMortyTheme.colors.primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .navigationBarsPadding()
                .padding(bottom = 54.dp)
                .align(
                    Alignment.BottomCenter
                )
        ) {
            Text(
                "Apply",
                style = RickAndMortyTheme.typography.title5,
                color = RickAndMortyTheme.colors.white,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}

@Composable
internal fun FilterChip(name: String, filter: String, function: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(bottom = 16.dp, start = 24.dp)
            .background(
                if (filter == name) RickAndMortyTheme.colors.primary else Color(0xFF1C2031),
                RoundedCornerShape(16.dp)
            )
            .clickable(onClick = {
                if (filter != name) function(name) else function("")
            })
    ) {
        Text(
            name,
            style = RickAndMortyTheme.typography.bodyDefault,
            color = RickAndMortyTheme.colors.grayNormal,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
        )
    }
}

@Composable
internal fun FilterSection(name: String, list: List<String>, filter: String, function: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 24.dp, top = 8.dp)
    ) {
        Text(
            name,
            style = RickAndMortyTheme.typography.bodyDefault,
            color = RickAndMortyTheme.colors.white,
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )
    }
    FlowRow() {
        repeat(list.size) { index ->
            FilterChip(list[index], function = function, filter = filter)
        }
    }
}
