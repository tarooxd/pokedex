package com.example.pokedex.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.pokedex.entity.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Upsert
    suspend fun addPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon ORDER BY name")
    fun readAllPokemonOrderByName(): Flow<List<Pokemon>>

    @Query("SELECT * FROM pokemon ORDER BY id")
    fun readAllPokemonOrderById(): Flow<List<Pokemon>>

    @Query("SELECT * FROM pokemon ORDER BY type")
    fun readAllPokemonOrderByFirstType(): Flow<List<Pokemon>>

//    @Query("SELECT * FROM pokemon ORDER BY second_type")
//    fun readAllPokemonOrderBySecondType(): Flow<List<Pokemon>>
}