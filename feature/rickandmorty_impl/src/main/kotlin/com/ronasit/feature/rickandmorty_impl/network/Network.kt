package com.ronasit.feature.rickandmorty_impl.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.ronasit.feature.rickandmorty_impl.Constants
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

fun createInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = (HttpLoggingInterceptor.Level.HEADERS)
    return logging
}

fun getMediaType(): MediaType {
    return "application/json".toMediaType()
}

fun buildOkHttpClient(): OkHttpClient {
    val interceptor = createInterceptor()
    return OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}

@ExperimentalSerializationApi
fun createRetrofit(): Retrofit.Builder {
    val mediaType = getMediaType()
    val okHttpClient = buildOkHttpClient()
    val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    return Retrofit.Builder()
        .baseUrl(Constants.baseUrl)
        .addConverterFactory(json.asConverterFactory(mediaType))
        .client(okHttpClient)
}

@ExperimentalSerializationApi
fun getRickAndMortyService(): RickAndMortyService {
    val retrofit = createRetrofit()
    return retrofit
        .build()
        .create(RickAndMortyService::class.java)
}

