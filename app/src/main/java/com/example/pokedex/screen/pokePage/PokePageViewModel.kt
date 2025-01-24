package com.example.pokedex.screen.pokePage

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.local.repository.LocalPokemonRepository
import com.example.pokedex.remote.dto.PokemonResponse
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
            when(sortType){
                SortType.FIRST_TYPE -> localRepository.getAllPokemonOrderByFirstType()
                SortType.SECOND_TYPE -> localRepository.getAllPokemonOrderBySecondType()
                SortType.ID -> localRepository.getAllPokemonOrderById()
                SortType.NAME -> localRepository.getAllPokemonOrderByName()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(PokePageState())

    val uiState = combine(_state, _sortType, _uiState){ state, sortType, uiState ->
        state.copy(
            uiState = uiState,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), PokePageState())

    fun onEvent(event: PokePageEvent){
        when(event){
            PokePageEvent.HideDialog -> {
                _state.update { it.copy(
                    isAddingPokemon = false
                ) }
            }

            PokePageEvent.SavePokemon -> {
                val id = uiState.value.pokeId
                viewModelScope.launch(Dispatchers.IO) {
                    remoteRepository.getPokemonFromApi(id)
                }
            }

            is PokePageEvent.SetPokeId -> {
                _state.update {
                    it.copy(
                        pokeId = event.id
                    )
                }
            }

            PokePageEvent.ShowDialog -> {
                _state.update { it.copy(
                    isAddingPokemon = true
                ) }
            }

            is PokePageEvent.SortPokemon -> {
                _sortType.value = event.sortType
            }
        }
    }
}