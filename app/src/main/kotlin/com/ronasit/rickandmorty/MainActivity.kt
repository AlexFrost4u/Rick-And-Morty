package com.ronasit.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ronasit.home.MainContainer
import com.ronasit.home.Splash

class MainActivity : ComponentActivity() {
    companion object {
        const val splashFadeDurationMillis = 1000
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()

        splashScreen.setOnExitAnimationListener { splashScreenViewProvider ->
            splashScreenViewProvider.view
                .animate()
                .setDuration(splashFadeDurationMillis.toLong())
                .withEndAction {
                    splashScreenViewProvider.remove()
                    setContent {
                        MainContainer()
                    }
                }.start()
            //setContent {
            //    MainContainer()
            //}
        }
    }
}
