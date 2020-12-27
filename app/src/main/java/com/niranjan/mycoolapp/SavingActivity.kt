package com.niranjan.mycoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.niranjan.mycoolapp.databinding.ActivitySavingBinding
import timber.log.Timber

const val AMOUNT_KEY = "AMOUNT_KEY"
class SavingActivity : AppCompatActivity() {

    lateinit var bindingSave : ActivitySavingBinding
    var amount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSave = DataBindingUtil.setContentView(this, R.layout.activity_saving)
        onIncrementAmount()
        Timber.i("onCreate called")

        if (savedInstanceState!= null){
            amount = savedInstanceState.getInt(AMOUNT_KEY)
            amountUpdate(amount)
        }
    }

    private fun onIncrementAmount() {
        bindingSave.floatingActionButton.setOnClickListener {
            amount++
            amountUpdate(amount)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.i("onSaveInstanceState called ")
        outState.putInt(AMOUNT_KEY, amount)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        amount = savedInstanceState.getInt(AMOUNT_KEY, 0)
        amountUpdate(amount)
        Timber.i("onRestoreInstanceState called")
    }

    private fun amountUpdate(amt: Int) {
        bindingSave.amountValue.text = amt.toString()
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy called")
    }
}