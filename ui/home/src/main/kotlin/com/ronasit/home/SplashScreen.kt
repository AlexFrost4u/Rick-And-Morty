package com.ronasit.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majorkik.home.R

@Preview(showBackground = true)
@Composable
fun Splash(){
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(R.drawable.stars_background),
            contentDescription = "",
            modifier = Modifier.fillMaxSize().padding(start = 16.dp, top = 98.dp, end = 25.dp,bottom = 64.dp)
        )
        Image(painter = painterResource(R.drawable.app_name),
            contentDescription = "",
            modifier = Modifier.padding(top=164.dp).size(140.dp,40.dp).align(Alignment.TopCenter))
        Image(painter = painterResource(R.drawable.portal),
            contentDescription = "",
            modifier = Modifier.padding(top=251.dp).size(314.dp,215.dp).align(Alignment.TopCenter))
    }
}
