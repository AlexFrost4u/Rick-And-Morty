package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_impl.Network.buildMoshi
import com.ronasit.feature.rickandmorty_impl.Network.createRetrofit
import com.ronasit.feature.rickandmorty_impl.Network.getRickAndMortyService
import org.koin.dsl.module

val rickAndMortyModule = module {
    single {
        buildMoshi()
        createRetrofit(get())
    }

    // Provide instance where interface is used
    single<RickAndMortyService> {
        getRickAndMortyService(get())
    }
}
