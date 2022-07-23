package com.example.viewmodellivedata.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TotalsViewModel : ViewModel() {
    var total = MutableLiveData<Int>()

    init {
        total.postValue(0)
    }

    fun increaseTotal() {
        total.postValue((total.value ?: 0) + 1)
    }

    fun getTotal(): LiveData<Int> {
        return total
    }
}