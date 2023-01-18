package com.example.mychick.kuroiler

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface KuroilerDao {

    @Insert
    suspend fun insert(kuroilerCost: KuroilerCost)

    @Query("SELECT * FROM kuroiler_cost")
    fun getAllCost(): Flow<List<KuroilerCost>>
    @Query("SELECT amount FROM kuroiler_cost")
    fun geCost(): Flow<Int>
}