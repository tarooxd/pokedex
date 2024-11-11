package com.example.pokedex.screen.pokePage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.R
import com.example.pokedex.connection.PokedexDatabase
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PokePageViewModel(application: Application): AndroidViewModel(application) {
     val readAlldata: Flow<List<Pokemon>>
    private var repository: PokemonRepository

    init {
        val pokemonDao = PokedexDatabase.getDatabase(application).pokemonDao()
        repository = PokemonRepository(pokemonDao)
        readAlldata = repository.getAllPokemon()
//        addPokemon(Pokemon(name = "Pikachu", type = "Elétrico", img = R.drawable.pikachu))
//        addPokemon(Pokemon(name = "Charizard", type = "Fogo", img = R.drawable.charizard))
//        addPokemon(Pokemon(name = "Ivysaur", type = "Planta", img = R.drawable.ivysaur))
//        addPokemon(Pokemon(name = "Piplup", type = "Água", img = R.drawable.piplup))
//        addPokemon(Pokemon(name = "Gengar", type = "Fantasma", img = R.drawable.gengar))
//        addPokemon(Pokemon(name = "Tepig", type = "Fogo", img = R.drawable.tepig))
//        addPokemon(Pokemon(name = "Abra", type = "Psíquico", img = R.drawable.abra))
//        addPokemon(Pokemon(name = "Chikorita", type = "Planta", img = R.drawable.chikorita))
//        addPokemon(Pokemon(name = "Clefairy", type = "Normal", img = R.drawable.clefairy))
    }

        fun addPokemon(pokemon: Pokemon){
            viewModelScope.launch(Dispatchers.IO) {
                repository.addPokemon(pokemon)
            }
        }

//        fun getAllPokemon(){
//            viewModelScope.launch(Dispatchers.IO) {
//                repository.addPokemon(pokemon)
//            }
//        }
}