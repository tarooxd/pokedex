package com.example.pokedex.screen.pokePage

sealed interface PokePageEvent {
    object SavePokemon : PokePageEvent
    object CheckPokemon : PokePageEvent
    data class SortPokemon(val sortType: SortType) : PokePageEvent
}