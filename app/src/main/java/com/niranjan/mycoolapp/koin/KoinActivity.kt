package com.niranjan.mycoolapp.koin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.niranjan.mycoolapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class KoinActivity : AppCompatActivity() {

    //lazily inject viewmodel
    val myViewModel: KoinViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // use your viewmodel
        myViewModel.doingSomethingWithKoinService()
    }
}