package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_impl.service.RickAndMortyService
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal object Network {
    fun buildMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    fun buildOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .build()
    }

    fun createRetrofit(moshi: Moshi,okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    fun getRickAndMortyService(retrofit: Retrofit.Builder): RickAndMortyService {
        return retrofit
            .build()
            .create(RickAndMortyService::class.java)
    }
}
