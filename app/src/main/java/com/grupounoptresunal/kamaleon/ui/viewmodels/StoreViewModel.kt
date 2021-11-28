package com.grupounoptresunal.kamaleon.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.grupounoptresunal.kamaleon.data.models.StoreInfo
import com.grupounoptresunal.kamaleon.data.repositories.StoreRepository
import kotlinx.coroutines.launch

class StoreViewModel(private val repo : StoreRepository): ViewModel() {
    private var _info: MutableLiveData<StoreInfo> = MutableLiveData()
    val info : LiveData<StoreInfo>get() = _info

    fun loadInfo(){
        viewModelScope.launch {
            val result = repo.loadinfo()
            _info.postValue(result)
        }
    }
}