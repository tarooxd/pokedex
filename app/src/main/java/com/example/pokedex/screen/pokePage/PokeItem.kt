package com.example.pokedex.screen.pokePage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.example.pokedex.R
import com.example.pokedex.entity.Pokemon
import com.example.pokedex.screen.pokePage.typeCard.CardColorsLogic

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
            Row { CardColorsLogic(pokemon.type1)
                pokemon.type2?.let { CardColorsLogic(it) } }
            SubcomposeAsyncImage(
                model = pokemon.img,
                contentDescription = pokemon.name + ".img",
                modifier = Modifier
                    .size(138.dp),
                error = {
                    if(LocalInspectionMode.current){
                        Image(painter = painterResource(id = R.drawable.abra), contentDescription = "PlaceHolder")
                    }
                }
            )
        }

    }
}