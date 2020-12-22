package com.niranjan.mycoolapp.kotlintut

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext

//
// Created by NIRANJAN KHATRI on 09/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//

fun main(){

    println("My Current Thread:${Thread.currentThread().name}")

    runBlocking {
        // background thread
        // download 1000 gb operation
        print("Downloading Thread: ${Thread.currentThread().name} \n")
        longRunningTask()
    }

    GlobalScope.launch(Dispatchers.Unconfined) {
        print("Loading Image Thread: ${Thread.currentThread().name} \n")
        longRunningTask()
    }

    CoroutineScope(Dispatchers.Unconfined + SupervisorJob()).launch {
        print("Network Connection Thread: ${Thread.currentThread().name} \n")
        longRunningTask()
    }

    runBlocking {
        // uploading 1mb  operation
        print("Uploading Thread: ${Thread.currentThread().name} \n")
        longRunningTask()
    }
}

 suspend fun longRunningTask(){
    delay(2000)
}