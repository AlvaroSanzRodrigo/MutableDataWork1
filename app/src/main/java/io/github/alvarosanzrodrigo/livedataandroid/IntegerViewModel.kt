package io.github.alvarosanzrodrigo.livedataandroid

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class IntegerViewModel : ViewModel() {

    // Create a LiveData with a String
    val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    // Rest of the ViewModel...
}