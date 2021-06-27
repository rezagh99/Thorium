package ir.ac.iust.thoriumproject3.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.ac.iust.thoriumproject3.Data.CellPowerDao
import ir.ac.iust.thoriumproject3.Data.CellPower


@Database(entities = arrayOf(CellPower::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cellPowerDao(): CellPowerDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "signal_strength")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }
}