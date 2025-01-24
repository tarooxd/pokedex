package com.example.pokedex.screen.pokePage

sealed interface PokePageEvent {
    object SavePokemon : PokePageEvent
    data class SetPokeId(val id: String) : PokePageEvent
    object ShowDialog : PokePageEvent
    object HideDialog : PokePageEvent
    data class SortPokemon(val sortType: SortType) : PokePageEvent
}