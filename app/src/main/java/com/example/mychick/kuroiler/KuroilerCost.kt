package com.example.mychick.kuroiler

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "kuroiler_cost")
data class KuroilerCost(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
    @PrimaryKey
    val type: String,
    val amount: Int
)
