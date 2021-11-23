package com.ronasit.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.majorkik.home.R

@Preview(showBackground = true)
@Composable
fun Splash() {
    Box(modifier = Modifier.fillMaxSize()) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(
            composition,
            progress
        )
        Image(
            painter = painterResource(R.drawable.ic_stars),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 98.dp, end = 25.dp, bottom = 64.dp)
        )
        Image(
            painter = painterResource(R.drawable.ic_app_name),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 164.dp)
                .size(140.dp, 40.dp)
                .align(Alignment.TopCenter)
        )
    }
}
