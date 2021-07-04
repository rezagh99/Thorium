package com.example.thorium.model.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.thorium.model.entity.CellInfo
import kotlinx.coroutines.CoroutineScope

@Database(entities = [CellInfo::class], version = 1, exportSchema = false)

public abstract class InfoDB : RoomDatabase(){
    abstract fun cellInfoDao(): InfoDao
    companion object {
        @Volatile
        private var INSTANCE: com.example.thorium.model.source.InfoDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): com.example.thorium.model.source.InfoDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InfoDB::class.java,
                    "cell_info_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}