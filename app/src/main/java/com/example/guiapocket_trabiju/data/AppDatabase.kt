package com.example.guiapocket_trabiju.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.guiapocket_trabiju.model.Estabelecimento

@Database(entities = [Estabelecimento::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun estabelecimentoDao(): EstabelecimentoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "guia_pocket_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}