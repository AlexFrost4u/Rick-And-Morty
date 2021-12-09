package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_impl.Network.buildMoshi
import com.ronasit.feature.rickandmorty_impl.Network.createRetrofit
import com.ronasit.feature.rickandmorty_impl.Network.getRickAndMortyService
import org.koin.dsl.module

@ExperimentalSerializationApi
val rickAndMortyModule = module {
    single { buildOkHttpClient(get()) }
    single { createRetrofit(get(),get()) }
    single { getRickAndMortyService(get()) }
    single { GetCharacters(get()) }
    single { GetLocations(get()) }
    single { createInterceptor() }
    single { getMediaType() }

    single<LocationRepository> {
        LocationRepositoryImpl(get())
    }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }
}
