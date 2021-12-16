package com.ronasit.character.list.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.insets.navigationBarsPadding
import com.ronasit.character.list.Filter.characterGender
import com.ronasit.character.list.Filter.characterSpecies
import com.ronasit.character.list.Filter.characterStatus
import com.ronasit.character.list.Filter.characterType
import com.ronasit.character.list.R
import com.ronasit.core.ui.theme.RickAndMortyTheme

@Composable
internal fun SheetContent() {
    val scroll = rememberScrollState()
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
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
                    modifier = Modifier.fillMaxWidth()
                )
            }

            FilterSection(name = "Status", list = characterStatus) {

            }
            FilterSection(name = "Species", list = characterSpecies) {

            }
            FilterSection(name = "Type", list = characterType) {

            }
            FilterSection(name = "Gender", list = characterGender) {

            }

            Spacer(
                Modifier
                    .padding(bottom = 116.dp)
                    .navigationBarsPadding()
            )
        }
        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = RickAndMortyTheme.colors.blackCard),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .navigationBarsPadding()
                .padding(bottom = 54.dp)
                .align(
                    Alignment.BottomCenter
                )) {
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
internal fun FilterChip(name: String, function: () -> Unit) {
    Box(modifier = Modifier
        .padding(bottom = 16.dp, start = 24.dp)
        .background(
            RickAndMortyTheme.colors.blackBG,
            RoundedCornerShape(16.dp)
        )
        .clickable { function }
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
internal fun FilterSection(name: String, list: List<String>, function: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp, start = 24.dp,top = 8.dp)
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
            FilterChip(list[index], { function })
        }
    }
}
