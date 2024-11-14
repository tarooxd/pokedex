package com.example.pokedex.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon (
    @PrimaryKey(autoGenerate = false)
    var id: Int,
    var name: String,
    var type: String,
    var img: String
)