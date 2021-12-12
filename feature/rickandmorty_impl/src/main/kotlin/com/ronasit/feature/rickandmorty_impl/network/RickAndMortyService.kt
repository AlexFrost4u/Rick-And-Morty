package com.ronasit.feature.rickandmorty_impl.network

import com.ronasit.feature.rickandmorty_impl.model.CharacterResponse
import com.ronasit.feature.rickandmorty_impl.model.LocationDetailResidentResponseItem
import com.ronasit.feature.rickandmorty_impl.model.LocationDetailResponse
import com.ronasit.feature.rickandmorty_impl.model.LocationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") pageNumber: Int,
        @Query("name") nameCharacter: String
    ): CharacterResponse

    @GET("location")
    suspend fun getAllLocations(
        @Query("page") pageNumber: Int,
        @Query("name") nameLocation: String
    ): LocationResponse

    @GET("location/{id}")
    suspend fun getLocationById(
        @Path("id") id: Int
    ): LocationDetailResponse

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: String
    ): List<LocationDetailResidentResponseItem>
}
