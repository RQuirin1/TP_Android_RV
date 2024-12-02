package com.example.app_recycledview.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModelDetails : ViewModel() {

    private val _data = MutableLiveData<Etudiant>()
    private val data: LiveData<Etudiant> = _data

    fun initData(){
        _data.value = null
    }

    fun updateData(data:Etudiant){
        _data.value = data
    }



    fun getData(): Etudiant = _data.value!!


}