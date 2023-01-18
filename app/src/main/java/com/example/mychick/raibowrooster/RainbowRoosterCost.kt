package com.example.mychick.raibowrooster

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rainbowrooster_cost")
data class RainbowRoosterCost(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val type: String,
    val amount: Int
)