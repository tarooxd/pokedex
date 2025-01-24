package com.example.pokedex.screen.pokePage.typeCard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CardLogic(color: Color, text: String) {
    Card(
        modifier = Modifier.padding(6.dp, 0.dp),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Text(text = text, modifier = Modifier.padding(8.dp, 4.dp))
    }
}