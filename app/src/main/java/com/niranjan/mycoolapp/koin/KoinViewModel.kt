package com.niranjan.mycoolapp.koin

import androidx.lifecycle.ViewModel

class KoinViewModel(val repository: KoinRepository) : ViewModel() {

    fun doingSomethingWithKoinService() = repository.provideService()
}