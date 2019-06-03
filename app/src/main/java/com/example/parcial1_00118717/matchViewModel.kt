package com.example.parcial1_00118717

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial1_00118717.dao.matchEntitie
import com.example.parcial1_00118717.dao.matchRoomDatabase
import com.example.parcial1_00118717.repos.matchRepository
import kotlinx.coroutines.launch

class matchViewModel(application: Application):AndroidViewModel(application) {
    private val repository: matchRepository
    val allMatches:LiveData<List<matchEntitie>>

    init {
        val matchDao = matchRoomDatabase.getDatabase(application, viewModelScope).partidoDao()
        repository= matchRepository(matchDao)
        allMatches=repository.allMatches
    }

    fun insert(match:matchEntitie) = viewModelScope.launch{
        repository.insert(match)
    }
}