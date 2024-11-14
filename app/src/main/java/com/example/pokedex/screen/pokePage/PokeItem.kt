package com.example.pokedex.screen.pokePage

import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.R
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.ui.theme.PokedexTheme

@Composable
fun PokeItem(pokemon: Pokemon, onClick: (Pokemon) -> Unit) {
    Card(
        onClick = { onClick(pokemon) },
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .width(IntrinsicSize.Min)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = pokemon.name, fontSize = 22.sp)
            Text(text = pokemon.type)
            AsyncImage(
                model = pokemon.img,
                contentDescription = pokemon.name + ".img",
                modifier = Modifier
                    .size(138.dp)
            )
        }

    }
}

//@Preview()
//@Composable
//fun PokeItemPreview() {
//    PokedexTheme {
//        PokeItem(
//            pokemon = Pokemon(
//                name = "Gengar", type = "Fantasma", img = BitmapFactory.decodeResource(
//                    LocalContext.current.resources, R.drawable.gengar
//                )
//            )
//        ) {
//        }
//    }
//}