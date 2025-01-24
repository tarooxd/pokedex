package com.example.pokedex.model

data class Pokemon(
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
