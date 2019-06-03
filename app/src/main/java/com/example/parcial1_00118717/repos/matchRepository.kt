package com.example.parcial1_00118717.repos

import androidx.lifecycle.LiveData
import com.example.parcial1_00118717.dao.matchDao
import com.example.parcial1_00118717.dao.matchEntitie

class matchRepository(private val matchDao: matchDao) {

    val allMatches : LiveData<List<matchEntitie>> = matchDao.getAllMatches()

    suspend fun insert(match: matchEntitie){
        matchDao.insert(match)
    }
}