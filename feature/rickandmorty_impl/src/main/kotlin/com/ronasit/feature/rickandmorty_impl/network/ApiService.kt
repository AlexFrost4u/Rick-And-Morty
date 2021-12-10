package com.ronasit.feature.rickandmorty_impl.network

import com.ronasit.feature.rickandmorty_impl.model.CharacterResponse
import com.ronasit.feature.rickandmorty_impl.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") pageNumber: Int,
        @Query("name") searchByName:String
    ): CharacterResponse

    @GET("location")
    suspend fun getAllLocations(
        @Query("page") pageNumber: Int,
        @Query("name") nameLocation: String
    ): LocationResponse

}
