package com.example.parcial1_00118717.dao

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface matchDao {
    @Query("SELECT * FROM partido")
    fun getAllMatches():LiveData<List<matchEntitie>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(partido:matchEntitie)

    @Query("DELETE FROM partido")
    suspend fun deleteAll()
}