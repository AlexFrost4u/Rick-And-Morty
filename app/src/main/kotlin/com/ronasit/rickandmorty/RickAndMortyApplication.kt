package com.ronasit.rickandmorty

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.ronaisit.character_detail.characterDetailModule
import com.ronasit.character.list.characterListModule
import com.ronasit.episode.list.episodeListModule
import com.ronasit.feature.rickandmorty_impl.rickAndMortyModule
import com.ronasit.location.list.locationListModule
import com.ronasit.ui.episode.detail.episodeDetailModule
import com.ronasit.ui.location.detail.locationDetailModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Logger.addLogAdapter(AndroidLogAdapter())
        Timber.plant(object : Timber.DebugTree() {
            override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
                Logger.log(priority, tag, message, t)
            }
        })

        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            modules(
                listOf(
                    rickAndMortyModule,
                    characterListModule,
                    characterDetailModule,
                    episodeListModule,
                    locationListModule,
                    locationDetailModule,
                    episodeDetailModule
                )
            )
        }
    }
}
