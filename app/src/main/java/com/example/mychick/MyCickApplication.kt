package com.example.mychick

import android.app.Application
import com.example.mychick.kuroiler.KuroilerRepository

class MyCickApplication : Application() {
    val database by lazy { MyChickDatabase.getDabase(this) }
    val kuroilerRepository by lazy { KuroilerRepository(database.kuroilerDao()) }
}