package com.example.mychick.kuroiler

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class KuroilerRepository(private val kuroilerDao: KuroilerDao) {

    val allCost: Flow<List<KuroilerCost>> = kuroilerDao.getAllCost()

    suspend fun isEmpty(): Boolean = kuroilerDao.isEmpty()

    fun getSumById(id: Int) {
        kuroilerDao.getSumById(id)
    }

    @WorkerThread
    suspend fun updateCost(id: Int, amount: Int) {
        kuroilerDao.updateCost(id, amount)
    }

    @WorkerThread
    suspend fun insert(kuroilerCost: KuroilerCost) {
        kuroilerDao.insert(kuroilerCost)
    }
}