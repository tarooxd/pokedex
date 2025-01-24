package com.example.pokedex.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon (
    @PrimaryKey(autoGenerate = false)
    var id: Int? = null,
    var name: String,
    var type1: String,
    var type2: String? = null,
    var ability1: String,
    var ability2: String? = null,
    var abilityH: String? = null,
    var hp: Int,
    var attack: Int,
    var defense: Int,
    var specialAttack: Int,
    var specialDefense: Int,
    var speed: Int,
    var img: String
)