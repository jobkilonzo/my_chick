package com.example.mychick

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.mychick.kuroiler.KuroilerCost
import com.example.mychick.kuroiler.KuroilerDao
import com.example.mychick.raibowrooster.RainbowRoosterCost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [KuroilerCost::class, RainbowRoosterCost::class],
    version = 3,
    exportSchema = false
)
abstract class MyChickDatabase : RoomDatabase() {
    abstract fun kuroilerDao(): KuroilerDao
    //abstract fun rainbowRoosterDao(): RainbowRoosterCost

    companion object {
        @Volatile
        private var INSTANCE: MyChickDatabase? = null

        // To launch a coroutine you need a CoroutineScope
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): MyChickDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyChickDatabase::class.java,
                    "my_chick_database"
                ).addCallback(RoomDatabaseCallback(scope)).build()

                INSTANCE = instance
                instance
            }
        }
    }

    class RoomDatabaseCallback(private val scope: CoroutineScope) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { _ -> scope.launch {} }
        }
    }
}