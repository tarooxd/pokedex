package com.example.pokedex.remote.repository

import com.example.pokedex.entity.Pokemon
import com.example.pokedex.local.repository.LocalPokemonRepository
import com.example.pokedex.remote.api.ApiService
import com.example.pokedex.remote.dto.PokemonResponse

class RemotePokemonRepository(
    private val apiService: ApiService,
    private val localPokemonRepository: LocalPokemonRepository
) {
    suspend fun getPokemonFromApi(id: Int): PokemonResponse {
        val pokemon = apiService.getPokemonById(id)
        localPokemonRepository.addPokemon(
            Pokemon(pokemon.id, pokemon.name, pokemon.types.get(0).type.name, pokemon.sprites.other.officialArtwork.frontDefault)
        )

        return pokemon
    }
}