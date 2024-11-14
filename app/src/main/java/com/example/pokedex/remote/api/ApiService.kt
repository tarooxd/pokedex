package com.example.pokedex.remote.api

import com.example.pokedex.remote.dto.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon/{id}")
    suspend fun getPokemonById(
        @Path("id") id: String
    ): PokemonResponse
}