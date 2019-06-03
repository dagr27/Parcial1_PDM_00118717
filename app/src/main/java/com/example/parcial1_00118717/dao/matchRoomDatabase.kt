package com.example.parcial1_00118717.dao

import android.content.Context
import androidx.room.CoroutinesRoom
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities=[matchEntitie::class], version = 1)
abstract class matchRoomDatabase :RoomDatabase(){
    abstract fun partidoDao():matchDao

    companion object{
        @Volatile
        private var INSTANCE: matchRoomDatabase?=null
        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ):matchRoomDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    matchRoomDatabase::class.java,
                    "partido"
                ).fallbackToDestructiveMigration()
                    .addCallback(matchDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
        private class matchDatabaseCallback(
            private val scope:CoroutineScope
        ):RoomDatabase.Callback(){
            override fun onOpen(db:SupportSQLiteDatabase){
                super.onOpen(db)
                INSTANCE?.let { database->
                    scope.launch {
                        populateDatabase(database.partidoDao())
                    }
                }
            }
        }
        suspend fun populateDatabase(matchDao: matchDao){
            matchDao.deleteAll()
            val match = matchEntitie(1,"Team1", "Team2",36,25,"1999-12-12")
            matchDao.insert(match)


        }
    }
}