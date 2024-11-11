package com.example.pokedex.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokedex.R

@Entity(tableName = "pokemon")
data class Pokemon (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String,
    var type: String,
    var img: Int
)

//fun getAllPokemon(): List<Pokemon>{
//    return listOf<Pokemon>(
//        Pokemon("Pikachu", "Elétrico", R.drawable.pikachu),
//        Pokemon("Charizard", "Fogo", R.drawable.charizard),
//        Pokemon("Ivysaur", "Planta", R.drawable.ivysaur),
//        Pokemon("Piplup", "Água", R.drawable.piplup),
//        Pokemon("Gengar", "Fantasma", R.drawable.gengar),
//        Pokemon("Tepig", "Fogo", R.drawable.tepig),
//        Pokemon("Abra", "Psíquico", R.drawable.abra),
//        Pokemon("Chikorita", "Planta", R.drawable.chikorita),
//        Pokemon("Clefairy", "Normal", R.drawable.clefairy)
//    )
//}