package com.ronasit.feature.rickandmorty_impl.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.ronasit.feature.rickandmorty_impl.Constants
import com.ronasit.feature.rickandmorty_impl.RickAndMortyService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber


fun createInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()

    logging.level = (HttpLoggingInterceptor.Level.BODY)
    return logging
}

fun getMediaType(): MediaType {
    return "application/json".toMediaType()
}

fun buildOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}

@ExperimentalSerializationApi
fun createRetrofit(okHttpClient: OkHttpClient, mediaType: MediaType): Retrofit.Builder {
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    return Retrofit.Builder()
        .baseUrl(Constants.baseUrl)
        .addConverterFactory(json.asConverterFactory(mediaType))
        .client(okHttpClient)
}

fun getRickAndMortyService(retrofit: Retrofit.Builder): RickAndMortyService {
    Timber.i("service")
    return retrofit
        .build()
        .create(RickAndMortyService::class.java)
}

