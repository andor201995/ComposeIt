package com.example.composeit.dynamic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DynamicContentViewModel : ViewModel() {
    val textFieldState = MutableLiveData("")
    val greetingListState = MutableLiveData<List<String>>(listOf("Anmol", "Andor"))

    fun onTextChanged(newText: String) {
        textFieldState.value = newText
    }

    fun onButtonClicked() {
        greetingListState.value = greetingListState.value?.toMutableList()?.apply {
            add(textFieldState.value ?: "Default Value")
        }
    }

}