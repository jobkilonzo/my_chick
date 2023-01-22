package com.example.mychick.kuroiler

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface KuroilerDao {

    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    suspend fun insert(kuroilerCost: KuroilerCost)

   // @Query("UPDATE sum SET value = value + :value WHERE id = :id")
    //suspend fun updateSum(id: Int, value: Long)
    @Query("UPDATE kuroiler_cost SET amount = amount + :amount WHERE type = :type")
    suspend fun updateCost(type: String, amount: Int)

    @Query("SELECT * FROM kuroiler_cost")
    fun getAllCost(): Flow<List<KuroilerCost>>

    @Query("SELECT (SELECT COUNT(*) FROM kuroiler_cost) == 0")
    suspend fun isEmpty(): Boolean

    @Query("SELECT amount FROM kuroiler_cost")
    fun geCost(): Flow<Int>
    @Query("SELECT type FROM kuroiler_cost WHERE type = :type")
    fun getSumById(type: String): String

    @Transaction
    suspend fun updateOrInsertCost(kuroilerCost: KuroilerCost) =
        // <-- this method updates value or insert new item, if id is not found
        updateCost(kuroilerCost.type, kuroilerCost.amount)
}