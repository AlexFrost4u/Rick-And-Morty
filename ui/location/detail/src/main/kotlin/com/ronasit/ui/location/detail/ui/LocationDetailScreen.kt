package com.ronasit.ui.location.detail.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.insets.statusBarsPadding
import com.orhanobut.logger.Logger
import com.ronasit.core.ui.theme.RickAndMortyTheme
import com.ronasit.ui.location.detail.R
import org.koin.androidx.compose.viewModel

@ExperimentalFoundationApi
@Composable
fun LocationDetailScreen(navController: NavController, id: Int?) {
    val viewModel: LocationDetailViewModel by viewModel()
    val state = viewModel.container.stateFlow.collectAsState()
    viewModel.getLocationDetail(id!!)
    Logger.e(state.value.locationDetail.toString())
    Logger.e(state.value.residentList.toString())
    RickAndMortyTheme {
        Scaffold(
            topBar = {
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
                            .clickable { navController.popBackStack() }
                    )
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(RickAndMortyTheme.colors.blackBG)
            ) {
                items(1) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .padding(16.dp)
                                .size(150.dp)
                                .background(RickAndMortyTheme.colors.blackCard, RoundedCornerShape(16.dp))
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_planet_48),
                                contentDescription = null,
                                tint = RickAndMortyTheme.colors.white,
                                modifier = Modifier
                                    .padding(50.dp)
                            )
                        }
                        Text(
                            "Earth",
                            style = RickAndMortyTheme.typography.title3,
                            textAlign = TextAlign.Center,
                            color = RickAndMortyTheme.colors.white,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

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
                                        "Planet",
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
                                        "C-137",
                                        style = RickAndMortyTheme.typography.bodyDefault,
                                        color = RickAndMortyTheme.colors.white,
                                        textAlign = TextAlign.Right,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp)
                    ) {
                        Text(
                            "Residents",
                            style = RickAndMortyTheme.typography.title5,
                            color = RickAndMortyTheme.colors.white,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                    CharacterList()
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
internal fun CharacterList() {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp, top = 16.dp, start = 8.dp, end = 24.dp)
    ) {
        repeat(10) { index ->
            Card(
                backgroundColor = RickAndMortyTheme.colors.blackCard,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .padding(start = 16.dp, bottom = 16.dp)
            ) {
                CharacterItem()
            }
        }
    }
}

@Composable
internal fun CharacterItem() {
    Column {
        Image(
            painter = rememberImagePainter("https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(RickAndMortyTheme.colors.blackCard)
                .fillMaxSize()
                .aspectRatio(1.0F)
        )
        Text(
            text = "Rick Sanchez",
            color = RickAndMortyTheme.colors.white,
            textAlign = TextAlign.Center,
            style = RickAndMortyTheme.typography.title5,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}
