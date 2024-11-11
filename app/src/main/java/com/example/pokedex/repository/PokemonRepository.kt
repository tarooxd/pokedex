package com.example.pokedex.repository

import com.example.pokedex.dao.PokemonDao
import com.example.pokedex.entity.Pokemon
import kotlinx.coroutines.flow.Flow

class PokemonRepository(private val pokemonDao: PokemonDao) {

    fun getAllPokemon(): Flow<List<Pokemon>>{
        return pokemonDao.readAllPokemon()
    }

    suspend fun addPokemon(pokemon: Pokemon){
        pokemonDao.addPokemon(pokemon)
    }
}