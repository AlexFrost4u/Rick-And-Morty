package com.ronasit.feature.rickandmorty_impl

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object Network {
    fun buildMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    fun createRetrofit(moshi: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    fun getRickAndMortyService(retrofit: Retrofit.Builder): RickAndMortyService {
        return retrofit
            .build()
            .create(RickAndMortyService::class.java)
    }
}
