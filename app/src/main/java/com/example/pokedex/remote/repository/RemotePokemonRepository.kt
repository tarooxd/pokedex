package com.example.pokedex.remote.repository

import android.util.Log
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.local.repository.LocalPokemonRepository
import com.example.pokedex.remote.api.ApiService
import com.example.pokedex.remote.dto.PokemonResponse

class RemotePokemonRepository(
    private val apiService: ApiService,
    private val localPokemonRepository: LocalPokemonRepository
) {
    suspend fun getPokemonFromApi(id: String){
        try {
        val pokemon = apiService.getPokemonById(id)
        localPokemonRepository.addPokemon(
            Pokemon(
                pokemon.id,
                pokemon.name.replaceFirstChar { it.uppercase() },
                pokemon.types[0].type.name,
                pokemon.types.getOrNull(1)?.type?.name,
                pokemon.abilities[0].ability.name,
                pokemon.abilities.getOrNull(1)?.ability?.name,
                pokemon.abilities.getOrNull(2)?.ability?.name,
                pokemon.stats[0].baseStat,
                pokemon.stats[1].baseStat,
                pokemon.stats[2].baseStat,
                pokemon.stats[3].baseStat,
                pokemon.stats[4].baseStat,
                pokemon.stats[5].baseStat,
                pokemon.sprites.other.officialArtwork.frontDefault
            )
        )
        }catch (e: Exception){
            Log.d("Pokemon $id não achado", e.message.toString())
        }
    }
}