package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.pokedex.screen.pokePage.PokePageViewModel
import com.example.pokedex.screen.pokePage.PokeScreen
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val pokePageViewModel: PokePageViewModel = koinViewModel()
            val state by pokePageViewModel.uiState.collectAsState()
            PokeScreen(
                state = state, onEvent = pokePageViewModel::onEvent
            )
        }
    }
}
