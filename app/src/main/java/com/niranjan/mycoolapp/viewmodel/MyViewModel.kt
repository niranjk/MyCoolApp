package com.niranjan.mycoolapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

//
// Created by NIRANJAN KHATRI on 09/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//

class MyViewModel : ViewModel(){

    var job = SupervisorJob()
    val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    fun longRunningTask(){
        scope.launch {
            delay(1000)
            println("Long running task")
        }
    }

    fun viewModelTask(){
        viewModelScope.launch {
            delay(1000)
            println("Long running task")
        }
    }

    fun withContextTask(){
        viewModelScope.launch {
            val operation1 = withContext(Dispatchers.IO){ taskOne()}
            val operation2 = withContext(Dispatchers.IO){ taskTwo()}
        }
    }

    fun taskOne(){
        // task 1
    }

    fun taskTwo(){
        // task 2
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}