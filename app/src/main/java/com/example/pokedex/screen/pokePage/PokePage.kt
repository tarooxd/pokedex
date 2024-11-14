package com.example.pokedex.screen.pokePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.ui.theme.PokedexTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokeScreen(){
    val viewModel = koinViewModel<PokePageViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    PokePage(uiState = uiState)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokePage(uiState: List<Pokemon>) {

    Scaffold(Modifier.safeDrawingPadding(), topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors()
                .copy(MaterialTheme.colorScheme.tertiaryContainer),
            title = {
                Text(text = "Pokédex", color = MaterialTheme.colorScheme.onTertiaryContainer)
            })
    }) {
        Column(
            Modifier.padding(it)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(180.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .weight(1f),
                content = {
                    itemsIndexed(uiState, itemContent = { _, item ->
                        PokeItem(item){ click ->
                            println(click.name)
                        }
                    })
                })
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    PokedexTheme {
//        PokePage(uiState = listOf(Pokemon(name = "Abra", type = "Fogo", img = R.drawable.abra),
//        Pokemon(name = "Charizard", type = "Fogo", img = R.drawable.charizard)))
//    }
//}