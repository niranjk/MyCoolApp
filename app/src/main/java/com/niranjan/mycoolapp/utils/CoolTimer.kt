package com.niranjan.mycoolapp.utils

import timber.log.Timber
import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*
import java.lang.Runnable

//
// Created by NIRANJAN KHATRI on 26/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//
class CoolTimer(lifecycle: Lifecycle): LifecycleObserver{

    // number of seconds counted
    var secondsCount = 0
    private var handler = Handler()
    private lateinit var runnable: Runnable

    init {
        // add this lifecycle observer which will allow for the class to react to changes in this activity lifecycle state.
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer() {
        runnable = Runnable {
            secondsCount++
            Timber.i("Timer is at: $secondsCount")
            handler.postDelayed(runnable, 1000)
        }
        // initally start timer
        handler.postDelayed(runnable, 1000)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer() {
        handler.removeCallbacks(runnable)
    }

}
