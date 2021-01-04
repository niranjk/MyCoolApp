package com.niranjan.mycoolapp.viewmodel

import androidx.lifecycle.ViewModel

//
// Created by NIRANJAN KHATRI on 01/01/2021.
// Copyright (c) 2021 NIRANJAN KHATRI. All rights reserved.
//
class GameViewModel : ViewModel() {


    // UI DATA surviving conf changes
    // The current word
    var surname = ""

    // The current score
    var score = 0

    // The list of words - the front of the list is the next word to guess
    private lateinit var surnameList: MutableList<String>



    init {
        resetList()
        nextSurname()
    }


    // Decision Making Codes

    private fun nextSurname() {
        // select and remove a surname form the list
        if (!surnameList.isEmpty()){
            surname = surnameList.removeAt(0)
        } else {
            // gameFinished()
        }

    }

    private fun resetList() {
        surnameList = mutableListOf(
            "Elizabeth",
            "Clinton",
            "Bush",
            "Merkel",
            "Trump",
            "Hillary",
            "Montana",
            "Presley",
            "Gates",
            "Ma",
            "Chan"
        )
        surnameList.shuffle()
    }



    fun onSkip(){
        score--
        nextSurname()
    }

    fun onCorrect(){
        score++
        nextSurname()
    }


    override fun onCleared() {
        super.onCleared()
    }
}