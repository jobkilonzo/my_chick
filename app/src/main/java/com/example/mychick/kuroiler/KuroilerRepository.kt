package com.example.mychick.kuroiler

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class KuroilerRepository(private val kuroilerDao: KuroilerDao) {
    val allCost: Flow<List<KuroilerCost>> = kuroilerDao.getAllCost()

    val cost: Flow<Int> = kuroilerDao.geCost()

    @WorkerThread
    suspend fun insert(kuroilerCost: KuroilerCost){
        kuroilerDao.insert(kuroilerCost)
    }


}