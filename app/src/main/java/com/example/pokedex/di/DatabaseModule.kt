package com.example.pokedex.di

import androidx.room.Room
import com.example.pokedex.connection.PokedexDatabase
import com.example.pokedex.local.repository.LocalPokemonRepository
import com.example.pokedex.remote.api.ApiService
import com.example.pokedex.remote.repository.RemotePokemonRepository
import com.example.pokedex.screen.pokePage.PokePageViewModel
import com.example.pokedex.util.Constants.Companion.BASE_URL
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext().applicationContext,
            PokedexDatabase::class.java,
            "pokemon_database"
        ).build()
    }

    single {
        get<PokedexDatabase>().pokemonDao()
    }
}

val appModule = module {

    viewModelOf(::PokePageViewModel)

    singleOf(::LocalPokemonRepository)

    singleOf(::RemotePokemonRepository)

//    singleOf(::ConverterBit)
}

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}