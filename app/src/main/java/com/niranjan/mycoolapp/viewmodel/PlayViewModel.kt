package com.niranjan.mycoolapp.viewmodel

import androidx.lifecycle.ViewModel
import timber.log.Timber

//
// Created by NIRANJAN KHATRI on 28/12/2020.
// Copyright (c) 2020 NIRANJAN KHATRI. All rights reserved.
//

class PlayViewModel : ViewModel(){

    init {
        Timber.i("PlayViewModel is created ..")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("PlayViewModel is destroyed...")
    }



}