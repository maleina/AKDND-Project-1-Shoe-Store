package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeStoreViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList


    init {
        createInitialShoeList()
    }

    private fun createInitialShoeList() {
        _shoeList.value = mutableListOf(Shoe("Air Max Plus", 8.0, "Nike", "Men's running shoe"),
        Shoe("Keeley Field 6 Inch Boots", 6.5, "Timberland", "Women's Casual, Leather Hiking Boot"))
    }

    override fun onCleared() {
        super.onCleared()
    }
}