package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_api.usecase.GetCharacters
import com.ronasit.feature.rickandmorty_impl.network.buildOkHttpClient
import com.ronasit.feature.rickandmorty_impl.network.createInterceptor
import com.ronasit.feature.rickandmorty_impl.network.createRetrofit
import com.ronasit.feature.rickandmorty_impl.network.getRickAndMortyService
import com.ronasit.feature.rickandmorty_impl.repository.*
import org.koin.dsl.module

val rickAndMortyModule = module {
    single { buildOkHttpClient(get()) }
    single { createRetrofit(get(),get()) }
    single { getRickAndMortyService(get()) }
    single { GetCharacters(get()) }
    single { createInterceptor() }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }
}
