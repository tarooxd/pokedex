package com.example.pokedex.local.repository

import com.example.pokedex.dao.PokemonDao
import com.example.pokedex.entity.Pokemon
import kotlinx.coroutines.flow.Flow

class LocalPokemonRepository(
    private val pokemonDao: PokemonDao
) {

    fun getAllPokemonOrderByName(): Flow<List<Pokemon>> {
        return pokemonDao.readAllPokemonOrderByName()
    }

    fun getAllPokemonOrderById(): Flow<List<Pokemon>> {
        return pokemonDao.readAllPokemonOrderById()
    }

    fun getAllPokemonOrderByFirstType(): Flow<List<Pokemon>> {
        return pokemonDao.readAllPokemonOrderByFirstType()
    }

    fun getAllPokemonOrderBySecondType(): Flow<List<Pokemon>> {
        return pokemonDao.readAllPokemonOrderBySecondType()
    }

    fun getLastPokemonID(): Int{
        return pokemonDao.getLastPokemonID()
    }

    suspend fun addPokemon(pokemon: Pokemon) {
        pokemonDao.addPokemon(pokemon)
    }


}