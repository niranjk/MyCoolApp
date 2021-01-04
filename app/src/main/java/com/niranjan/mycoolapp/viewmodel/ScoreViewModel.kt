package com.niranjan.mycoolapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//
// Created by NIRANJAN KHATRI on 01/01/2021.
// Copyright (c) 2021 NIRANJAN KHATRI. All rights reserved.
//
class ScoreViewModel(finalScore: Int) : ViewModel() {

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain : LiveData<Boolean> = _eventPlayAgain

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    init {
        _score.value = finalScore
    }

    fun onPlayAgain(){
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete(){
        _eventPlayAgain.value = false
    }
}