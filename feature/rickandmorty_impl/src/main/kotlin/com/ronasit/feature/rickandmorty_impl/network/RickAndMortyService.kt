package com.ronasit.feature.rickandmorty_impl.network

import com.ronasit.feature.rickandmorty_impl.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") pageNumber: Int,
        @Query("name") nameCharacter: String,
        @Query("status") status: String,
        @Query("species") species: String,
        @Query("type") type: String,
        @Query("gender") gender: String,

        ): CharacterResponse

    @GET("location")
    suspend fun getAllLocations(
        @Query("page") pageNumber: Int,
        @Query("name") nameLocation: String,
        @Query("type") type: String,
        @Query("dimension") dimension: String
    ): LocationResponse

    @GET("episode")
    suspend fun getAllEpisodes(
        @Query("page") pageNumber: Int,
        @Query("name") nameLocation: String,
        @Query("episode") episode: String
    ): EpisodeResponse


    @GET("location/{id}")
    suspend fun getLocation(
        @Path("id") id: String?
    ): LocationResult

    @GET("episode/{id}")
    suspend fun getEpisode(
        @Path("id") id: String?
    ): EpisodeResult

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: String
    ): CharacterResult


    @GET("character/{id}")
    suspend fun getCharacterList(
        @Path("id") id: String
    ): List<CharacterResult>

    @GET("episode/{id}")
    suspend fun getEpisodeList(
        @Path("id") id: String?
    ): List<EpisodeResult>

}
