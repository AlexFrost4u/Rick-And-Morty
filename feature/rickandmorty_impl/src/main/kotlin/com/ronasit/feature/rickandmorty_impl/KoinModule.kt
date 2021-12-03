package com.ronasit.feature.rickandmorty_impl

import androidx.paging.PagingConfig
import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_api.use_cases.GetCharacters
import com.ronasit.feature.rickandmorty_impl.Network.buildMoshi
import com.ronasit.feature.rickandmorty_impl.Network.buildOkHttpClient
import com.ronasit.feature.rickandmorty_impl.Network.createRetrofit
import com.ronasit.feature.rickandmorty_impl.Network.getRickAndMortyService
import com.ronasit.feature.rickandmorty_impl.repository_impl.CharacterRepositoryImpl
import com.ronasit.feature.rickandmorty_impl.service.RickAndMortyService
import org.koin.dsl.module

val rickAndMortyModule = module {
    single {
        buildMoshi()
        buildOkHttpClient()
        createRetrofit(get(),get())
        getRickAndMortyService(get())
        GetCharacters(get())
    }

    single<CharacterRepository>{
        CharacterRepositoryImpl(get())
    }
}
