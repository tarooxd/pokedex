package com.example.pokedex.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pokedex.entity.Pokemon
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPokemon(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon ORDER BY name")
    fun readAllPokemon(): Flow<List<Pokemon>>
}