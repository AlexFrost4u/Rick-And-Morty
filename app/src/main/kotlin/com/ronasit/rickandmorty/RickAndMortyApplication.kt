package com.ronasit.rickandmorty

import android.app.Application
import com.ronasit.episode.list.characterListModule
import com.ronasit.feature.rickandmorty_impl.rickAndMortyModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            modules(listOf(rickAndMortyModule,characterListModule))
        }
    }
}
