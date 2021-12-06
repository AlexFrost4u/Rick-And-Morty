package com.ronasit.feature.rickandmorty_impl.network

import com.ronasit.feature.rickandmorty_impl.models.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") pageNumber: Int
    ): CharacterResponse



    /*@GET("character")
    suspend fun getTestCharacters():CharacterResponse*/
}
