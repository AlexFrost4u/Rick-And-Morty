package com.ronasit.feature.rickandmorty_impl

import com.squareup.moshi.Moshi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

private fun buildMoshi(): Moshi {
    return Moshi.Builder()
        .build()
}

private fun createRetrofit(moshi: Moshi): Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl(Constants.baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
}

private fun getRickAndMortyService(retrofit: Retrofit.Builder): RickAndMortyService {
    return retrofit
        .build()
        .create(RickAndMortyService::class.java)
}
