package com.example.mychick

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mychick.kuroiler.KuroilerCost
import com.example.mychick.kuroiler.KuroilerDao
import com.example.mychick.raibowrooster.RainbowRoosterCost

@Database(entities = [KuroilerCost::class, RainbowRoosterCost::class], version = 2, exportSchema = false)
abstract class MyChickDatabase: RoomDatabase() {
    abstract fun kuroilerDao(): KuroilerDao
    //abstract fun rainbowRoosterDao(): RainbowRoosterCost

    companion object{
        @Volatile
        private var INSTANCE: MyChickDatabase?= null

        fun getDabase(context: Context): MyChickDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyChickDatabase::class.java,
                    "my_chick_database"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance

            }
        }
    }
}