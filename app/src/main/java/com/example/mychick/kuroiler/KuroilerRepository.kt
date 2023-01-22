package com.example.mychick.kuroiler

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class KuroilerRepository(private val kuroilerDao: KuroilerDao) {
    val allCost: Flow<List<KuroilerCost>> = kuroilerDao.getAllCost()

    //val cost: Flow<Int> = kuroilerDao.geCost()



    suspend fun isEmpty(): Boolean = kuroilerDao.isEmpty()

    fun getSumById(type: String){
        kuroilerDao.getSumById(type)
    }

   // val cost = kuroilerDao.updateOrInsertCost(KuroilerCost())
   @WorkerThread
   suspend fun updateCost(type: String, amount: Int){
       kuroilerDao.updateCost(type, amount)
   }
    @WorkerThread
    suspend fun insert(kuroilerCost: KuroilerCost){
        kuroilerDao.insert(kuroilerCost)
    }


}