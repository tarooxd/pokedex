package com.example.pokedex.screen.pokePage

import com.example.pokedex.entity.Pokemon

data class PokePageState (
    val uiState: List<Pokemon> = emptyList(),
    val pokeId: Int = 1,
    val isAddingPokemon: Boolean = true,
    val sortType: SortType = SortType.ID
)