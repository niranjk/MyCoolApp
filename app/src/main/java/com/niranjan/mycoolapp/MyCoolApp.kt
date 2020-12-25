package com.niranjan.mycoolapp

import android.app.Application
import timber.log.Timber

//
// Created by NIRANJAN KHATRI on 25/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//

class MyCoolApp : Application(){

    override fun onCreate() {
        super.onCreate()
        // do the utility setup here
        // we setup the timber here
        Timber.plant(Timber.DebugTree())
    }
}