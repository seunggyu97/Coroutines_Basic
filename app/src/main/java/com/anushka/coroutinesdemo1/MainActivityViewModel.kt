package com.anushka.coroutinesdemo1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    fun getUserData(){
        viewModelScope.launch {
            // 작업할 코드
        }
    }

}