package com.example.pokedex.connection

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokedex.dao.PokemonDao
import com.example.pokedex.entity.Pokemon

@Database(
    entities = [Pokemon::class],
    version = 1
)
abstract class PokedexDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object{
        @Volatile
        private var INSTANCE: PokedexDatabase? = null

        fun getDatabase(context: Context): PokedexDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                return Room.databaseBuilder(
                    context.applicationContext,
                    PokedexDatabase::class.java,
                    "pokemon_database"
                ).build()
            }
        }
    }
}