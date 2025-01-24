package com.example.pokedex.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    val id: Int,
    val height: Float,
    val weight: Float,
    val name: String,
    @SerializedName("past_types")
    val pastTypes: List<PastType>,
    val abilities: List<AbilityInfo>,
    val types: List<Types>,
    val sprites: Sprite,
    val stats: List<Stats>,
)

data class Sprite(
        val other: OtherThings
)

data class OtherThings(
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_shiny")
    val frontShiny: String
)

data class PastType(
    val generation: Generation,
    val types: List<Types>
)

data class Generation(
    val name: String,
    val url: String
)

data class Types(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
    val url: String
)

data class AbilityInfo(
    val ability: Ability,
    @SerializedName("is_hidden")
    val isHidden: Boolean,
    val slot: Int
)

data class Ability(
    val name: String,
    val url: String
)

data class Stats(
    @SerializedName("base_stat")
    val baseStat: Int,
    val effort: Int,
)