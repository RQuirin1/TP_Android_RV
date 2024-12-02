package com.example.app_recycledview.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val _data = MutableLiveData<ArrayList<Etudiant>>()
    val data: LiveData<ArrayList<Etudiant>> get() = _data

    fun initData() {
        val initialData = arrayListOf<Etudiant>()
        _data.value = initialData
    }

    fun updateData(data: ArrayList<Etudiant>) {
        _data.value = data
    }

}