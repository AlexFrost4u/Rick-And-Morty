package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_api.use_cases.GetCharacters
import com.ronasit.feature.rickandmorty_impl.Network.buildMoshi
import com.ronasit.feature.rickandmorty_impl.Network.buildOkHttpClient
import com.ronasit.feature.rickandmorty_impl.Network.createRetrofit
import com.ronasit.feature.rickandmorty_impl.Network.getRickAndMortyService
import com.ronasit.feature.rickandmorty_impl.repository_impl.CharacterRepositoryImpl
import org.koin.dsl.module

val rickAndMortyModule = module {
    single { buildMoshi() }
    single { buildOkHttpClient() }
    single { createRetrofit(get(), get()) }
    single { getRickAndMortyService(get()) }
    single { GetCharacters(get()) }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }
}
