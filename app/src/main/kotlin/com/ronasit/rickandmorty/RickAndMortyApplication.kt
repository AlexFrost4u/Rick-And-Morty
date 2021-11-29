package com.ronasit.rickandmorty

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin


class RickAndMortyApplication: Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin{
            androidContext(this@RickAndMortyApplication)
            modules(listOf())
        }
    }

}
