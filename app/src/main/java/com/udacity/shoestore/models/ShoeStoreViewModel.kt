package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeStoreViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList : LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _eventShoeAdded = MutableLiveData<Boolean>()
    val eventShoeAdded : LiveData<Boolean>
        get() = _eventShoeAdded

    init {
        _eventShoeAdded.value = false
        createInitialShoeList()
    }

    private fun createInitialShoeList() {
        _shoeList.value = mutableListOf(Shoe("Air Max Plus", 8.0, "Nike", "Men's running shoe"),
        Shoe("Keeley Field 6 Inch Boots", 6.5, "Timberland", "Women's Casual, Leather Hiking Boot"))
    }

    fun updateShoeList(shoe : Shoe) {
        // add shoe to shoe list
        shoeList.value?.add(shoe)
        // set the event to true to trigger navigation
        _eventShoeAdded.value = true
    }

    fun onNavigateComplete() {
        // reset the event to false after navigation is complete
        _eventShoeAdded.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}