package com.example.pokedex.screen.pokePage

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.local.repository.LocalPokemonRepository
import com.example.pokedex.remote.repository.RemotePokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class PokePageViewModel(
    private val localRepository: LocalPokemonRepository,
    private val remoteRepository: RemotePokemonRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _sortType = MutableStateFlow(SortType.ID)

    private val _uiState = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                SortType.FIRST_TYPE -> localRepository.getAllPokemonOrderByFirstType()
                SortType.SECOND_TYPE -> localRepository.getAllPokemonOrderBySecondType()
                SortType.ID -> localRepository.getAllPokemonOrderById()
                SortType.NAME -> localRepository.getAllPokemonOrderByName()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(PokePageState())

    val uiState = combine(_state, _sortType, _uiState) { state, sortType, uiState ->
        state.copy(
            uiState = uiState,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PokePageState())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            onEvent(PokePageEvent.CheckPokemon)
            onEvent(PokePageEvent.SavePokemon)
        }
    }

    fun onEvent(event: PokePageEvent) {
        when (event) {

            PokePageEvent.SavePokemon -> {
                var id = _state.value.pokeId
                if(id == 0) id = 1
                viewModelScope.launch(Dispatchers.IO) {
                    while (_state.value.isAddingPokemon) {
                        try {
                            remoteRepository.getPokemonFromApi(id)
                            id++
                        } catch (e: Exception) {
                            Log.d("Pagina indisponivel", e.message.toString())
                            _state.update {
                                it.copy(
                                    isAddingPokemon = false
                                )
                            }
                        }
                    }
                }
                Log.d("Aviso", "Todos pokemons já adicionados")
            }

            is PokePageEvent.SortPokemon -> {
                _sortType.value = event.sortType
            }

            PokePageEvent.CheckPokemon -> {
                val lastID = localRepository.getLastPokemonID()
                _state.update {
                    it.copy(
                        pokeId = lastID
                    )
                }
            }
        }
    }
}