package com.ronasit.feature.rickandmorty_impl

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.codegen.JsonClassCodegenProcessor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val rickAndMortyModule = module {
    single {
        moshi()
    }

    single {
        retrofit(get())
    }

    // Provide instance where interface is used
    single<RickAndMortyService> {
        rickAndMortyService(get())
    }
}

private fun moshi(): Moshi {
    return Moshi.Builder()
        .add((JsonClassCodegenProcessor()))
        .build()
}

private fun retrofit(moshi: Moshi): Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
}

private fun rickAndMortyService(retrofit: Retrofit.Builder): RickAndMortyService {
    return retrofit
        .build()
        .create(RickAndMortyService::class.java)
}
