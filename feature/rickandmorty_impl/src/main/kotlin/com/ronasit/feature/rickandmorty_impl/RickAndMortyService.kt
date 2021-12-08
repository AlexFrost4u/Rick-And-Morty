package com.ronasit.feature.rickandmorty_impl

import com.ronasit.feature.rickandmorty_impl.data_models.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("location")
    suspend fun getAllLocations(
        @Query("page") pageNumber: Int
    ): LocationResponse
}

