package com.example.mychick.raibowrooster

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RainbowRoosterDao {
    @Insert
    fun insert(rainbowRoosterCost: RainbowRoosterCost)

    @Query("SELECT * FROM rainbowrooster_cost")
    fun getAllCost(): Flow<List<RainbowRoosterCost>>
}