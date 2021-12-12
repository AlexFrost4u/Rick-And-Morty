package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_api.repository.CharacterRepository
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailRepository
import com.ronasit.feature.rickandmorty_api.repository.LocationDetailResidentRepository
import com.ronasit.feature.rickandmorty_api.repository.LocationRepository
import com.ronasit.feature.rickandmorty_api.usecase.GetCharactersUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetLocationDetailUseCase
import com.ronasit.feature.rickandmorty_api.usecase.GetLocationsUseCase
import com.ronasit.feature.rickandmorty_impl.network.getRickAndMortyService
import com.ronasit.feature.rickandmorty_impl.repository.CharacterRepositoryImpl
import com.ronasit.feature.rickandmorty_impl.repository.LocationDetailRepositoryImpl
import com.ronasit.feature.rickandmorty_impl.repository.LocationDetailResidentRepositoryImpl
import com.ronasit.feature.rickandmorty_impl.repository.LocationRepositoryImpl
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.dsl.module

@ExperimentalSerializationApi
val rickAndMortyModule = module {
    single { getRickAndMortyService() }
    single { GetCharactersUseCase(get()) }
    single { GetLocationsUseCase(get()) }
    single { GetLocationDetailUseCase(get()) }

    single<LocationRepository> {
        LocationRepositoryImpl(get())
    }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }

    single<LocationDetailRepository> {
        LocationDetailRepositoryImpl(get())
    }

    single<LocationDetailResidentRepository> {
        LocationDetailResidentRepositoryImpl(get())
    }
}
