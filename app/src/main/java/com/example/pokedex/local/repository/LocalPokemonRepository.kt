package com.example.pokedex.local.repository

import com.example.pokedex.dao.PokemonDao
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.remote.api.ApiService
import kotlinx.coroutines.flow.Flow

class LocalPokemonRepository(
    private val pokemonDao: PokemonDao
) {

    fun getAllPokemon(): Flow<List<Pokemon>> {
        return pokemonDao.readAllPokemon()
    }

    suspend fun addPokemon(pokemon: Pokemon) {
        pokemonDao.addPokemon(pokemon)
    }


}