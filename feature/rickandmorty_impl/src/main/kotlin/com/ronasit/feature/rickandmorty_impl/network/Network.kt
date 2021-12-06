package com.ronasit.feature.rickandmorty_impl.network

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

fun createRetrofit(okHttpClient: OkHttpClient, mediaType: MediaType): Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl(Constants.baseUrl)
        .addConverterFactory(Json.asConverterFactory(mediaType))
        .client(okHttpClient)
}

fun getRickAndMortyService(retrofit: Retrofit.Builder): RickAndMortyService {
    Timber.i("service")
    return retrofit
        .build()
        .create(RickAndMortyService::class.java)
}

