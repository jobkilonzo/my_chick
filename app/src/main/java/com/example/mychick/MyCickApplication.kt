package com.example.mychick

import android.app.Application
import com.example.mychick.kuroiler.KuroilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyCickApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database by lazy { MyChickDatabase.getDatabase(this, applicationScope) }
    val kuroilerRepository by lazy { KuroilerRepository(database.kuroilerDao()) }
}