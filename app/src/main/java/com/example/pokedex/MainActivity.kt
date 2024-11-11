package com.example.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.screen.pokePage.PokePage
import com.example.pokedex.screen.pokePage.PokePageViewModel
import com.example.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    private val pokemonViewModel: PokePageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokePage(pokemonViewModel)
        }
    }
}

//@Preview
//@Composable
//fun preview() {
//    PokedexTheme {
//        PokePage()
//    }
//}