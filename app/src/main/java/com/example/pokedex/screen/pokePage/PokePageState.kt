package com.example.pokedex.screen.pokePage

import com.example.pokedex.entity.Pokemon

data class PokePageState (
    val uiState: List<Pokemon> = emptyList(),
    val pokeId: String = "",
    val isAddingPokemon: Boolean = false,
    val sortType: SortType = SortType.ID
)