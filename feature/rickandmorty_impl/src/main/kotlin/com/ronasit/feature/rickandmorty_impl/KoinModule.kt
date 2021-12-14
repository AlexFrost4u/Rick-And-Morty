package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_api.repository.*
import com.ronasit.feature.rickandmorty_api.usecase.GetCharactersUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetEpisodesUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetLocationsUseCase
import com.ronasit.feature.rickandmorty_impl.network.getRickAndMortyService
import com.ronasit.feature.rickandmorty_impl.repository.*
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.dsl.module

@ExperimentalSerializationApi
val rickAndMortyModule = module {
    single { getRickAndMortyService() }
    single { GetCharactersUseCase(get()) }
    single { GetLocationsUseCase(get()) }
    single { GetEpisodesUseCase(get()) }

    single<LocationRepository> {
        LocationRepositoryImpl(get())
    }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }

    single<EpisodeRepository> {
        EpisodeRepositoryImpl(get())
    }

    single<LocationDetailRepository> {
        LocationDetailRepositoryImpl(get())
    }

    single<LocationDetailResidentRepository> {
        LocationDetailResidentRepositoryImpl(get())
    }
}
