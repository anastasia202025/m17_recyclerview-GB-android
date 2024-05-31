package com.example.hw17.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw17.data.Repository
import com.example.hw17.data.model.PhotosMarsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _photosMars = MutableStateFlow(PhotosMarsModel(listOf()))
    val photosMars = _photosMars.asStateFlow()

    fun loadData() {
        viewModelScope.launch {
            try {
                val photos = repository.loadMars()
                _photosMars.value = photos ?: PhotosMarsModel(listOf())
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("myLog", "Error: ${e.message}", e)
            }
        }
    }

}