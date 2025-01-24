package com.example.pokedex.screen.pokePage.typeCard

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.util.Locale

@Composable
fun CardColorsLogic(text: String) {
    val nText = text.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }

    val typeColorMap = mapOf(
        "Fire" to Color(0xFFFA8072),
        "Water" to Color(0xFF00FFFF),
        "Flying" to Color(0xFFF0F8FF),
        "Electric" to Color(0xFFFFFF00),
        "Grass" to Color(0xFF32CD32),
        "Ice" to Color(0xFFE0FFFF),
        "Poison" to Color(0xFFAA5599),
        "Ground" to Color(0xFFDDBB55),
        "Rock" to Color(0xFFBBAA66),
        "Bug" to Color(0xFF006400),
        "Ghost" to Color(0xFF6666BB),
        "Steel" to Color(0xFFaaaabb),
        "Psychic" to Color(0xFFFF5599),
        "Dragon" to Color(0xFF7766ee),
        "Dark" to Color(0xFF775544),
        "Fairy" to Color(0xFFEE99EE),
        "Fighting" to Color(0xFFBB5544),
        "Normal" to Color(0xFFAAAA99)
    )

    val color = typeColorMap[nText] ?: Color.Black

    CardLogic(color, nText)
}
