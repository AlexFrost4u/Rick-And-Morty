package com.ronasit.feature.rickandmorty_impl.network

import com.ronasit.feature.rickandmorty_impl.model.*
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

    @GET("episode")
    suspend fun getAllEpisodes(
        @Query("page") pageNumber: Int,
        @Query("name") nameLocation: String
    ): EpisodeResponse

    @GET("location/{id}")
    suspend fun getLocationById(
        @Path("id") id: Int?
    ): LocationDetailResponse

    @GET("episode/{id}")
    suspend fun getEpisodeById(
        @Path("id") id: Int?
    ): EpisodeDetailResponse

    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: String
    ): List<LocationDetailResidentResponseItem>
}
