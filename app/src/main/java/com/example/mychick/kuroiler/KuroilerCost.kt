package com.example.mychick.kuroiler

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kuroiler_cost")
data class KuroilerCost(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "amount")val amount: Int? = null,
    @ColumnInfo(name = "type")val type: String? = null
)
