package com.example.pokedex.connection

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokedex.dao.PokemonDao
import com.example.pokedex.entity.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 1
)
//@TypeConverters(Converters::class)
abstract class PokedexDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}