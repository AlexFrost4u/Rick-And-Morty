package com.ronasit.feature.rickandmorty_impl.service

import com.ronasit.feature.rickandmorty_impl.data_models.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") pageNumber: Int
    ): CharacterResponse
}
