@file:Suppress("detekt.MagicNumber","detekt.WildcardImport")

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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.majorkik.home.R

@Preview(showBackground = true)
@Composable
fun SplashScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_animation))
        val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

        Image(
            painter = painterResource(R.drawable.bg_splash),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
        )

        LottieAnimation(
            composition,
            progress,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 180.dp)
                .size(30.dp)
                .scale(4f)
        )
    }
}
