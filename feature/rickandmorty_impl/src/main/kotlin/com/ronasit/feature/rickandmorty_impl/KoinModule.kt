package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_api.repository.LocationRepository
import com.ronasit.feature.rickandmorty_api.use_cases.GetLocations
import com.ronasit.feature.rickandmorty_impl.network.*
import com.ronasit.feature.rickandmorty_impl.repository_impl.LocationRepositoryImpl
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.dsl.module

@ExperimentalSerializationApi
val rickAndMortyModule = module {

    single { buildOkHttpClient(get()) }
    single { createRetrofit(get(), get()) }
    single { getRickAndMortyService(get()) }
    single { GetLocations(get()) }
    single { createInterceptor() }
    single { getMediaType() }

    single<LocationRepository> {
        LocationRepositoryImpl(get())
    }

}
