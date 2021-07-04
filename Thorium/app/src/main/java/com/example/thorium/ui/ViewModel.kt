package com.example.thorium.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.thorium.model.entity.CellInfo
import com.example.thorium.model.repo.Repository
import com.example.thorium.model.source.InfoDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: Repository
    val info: LiveData<List<CellInfo>>

    init {
        val infoDao = InfoDB.getDatabase(application, viewModelScope).cellInfoDao()
        repository = Repository(infoDao)
        info = repository.data


    }

    fun insert(cellInfo: CellInfo) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(cellInfo)
    }
}
