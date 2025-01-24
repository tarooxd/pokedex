package com.example.pokedex.screen.pokePage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokeAddDialog(
    state: PokePageState,
    onEvent: ((PokePageEvent) -> Unit)?
) {
    AlertDialog(
        onDismissRequest = {
            if (onEvent != null) {
                onEvent(PokePageEvent.HideDialog)
                onEvent(PokePageEvent.SetPokeId(""))
            }
        },
        confirmButton = {
            Button(onClick = {
                if (onEvent != null) {
                    onEvent(PokePageEvent.SavePokemon)
                    onEvent(PokePageEvent.HideDialog)
                    onEvent(PokePageEvent.SetPokeId(""))
                }
            }) {
                Text("OK")
            }
        },
        title = { Text(text = "Adicione um Pokemon") },
        text = {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = state.pokeId,
                    onValueChange = { id ->
                        if (onEvent != null) {
                            onEvent(PokePageEvent.SetPokeId(id.lowercase()))
                        }
                    },
                    placeholder = {
                        Text(text = "Pokemon ID or Name")
                    }
                )
            }
        }
    )
}