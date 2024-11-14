package com.example.pokedex.screen.pokePage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.local.repository.LocalPokemonRepository
import com.example.pokedex.remote.repository.RemotePokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokePageViewModel(
    private val localRepository: LocalPokemonRepository,
    private val remoteRepository: RemotePokemonRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow<List<Pokemon>>(emptyList())
    val uiState = _uiState.asStateFlow()

    init{
        getAllPokemon()
//        addPokemon(Pokemon(name = "Abra", type = "Psych", img = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/35.png"))
        viewModelScope.launch(Dispatchers.IO){
            val response = remoteRepository.getPokemonFromApi(4)
        println(response)
        }
    }

    fun addPokemon(pokemon: Pokemon) {
        viewModelScope.launch(Dispatchers.IO) {
            localRepository.addPokemon(pokemon)
        }
    }

    fun getAllPokemon() {
        viewModelScope.launch(Dispatchers.IO) {
            localRepository.getAllPokemon().collect { pokemonList ->
                _uiState.value = pokemonList
            }
        }
    }
}