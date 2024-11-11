package com.example.pokedex.screen.pokePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.entity.Pokemon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokePage(viewModel: PokePageViewModel) {
    val pokemonList by viewModel.readAlldata.collectAsState(initial = emptyList())

    Scaffold(Modifier.safeDrawingPadding(), topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors()
                .copy(MaterialTheme.colorScheme.tertiaryContainer),
            title = {
                Text(text = "Pokédex", color = MaterialTheme.colorScheme.onTertiaryContainer)
            })
    }) {
        Column (
            Modifier.padding(it)){
            LazyVerticalGrid(
                columns = GridCells.Adaptive(180.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .weight(1f),
                content = {
                    itemsIndexed(pokemonList, itemContent = { index, item ->
                        PokeItem(item)
                    }
                    )
                })
            BottomAppBar(
                modifier = Modifier,actions = {
                    Text(text = "Teste")
                }
            )
        }
    }
}

@Composable
fun PokeItem(item: Pokemon) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = item.name, fontSize = 22.sp)
        Text(text = item.type)
        Image(
            painter = painterResource(id = item.img),
            contentDescription = item.name,
            modifier = Modifier.size(138.dp)
        )
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    PokedexTheme {
//        PokePage()
//    }
//}