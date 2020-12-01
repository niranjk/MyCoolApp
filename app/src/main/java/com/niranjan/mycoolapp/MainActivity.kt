package com.niranjan.mycoolapp

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.niranjan.mycoolapp.databinding.ActivityMainBinding
import com.niranjan.mycoolapp.fragment.BoxFragment
import com.niranjan.mycoolapp.fragment.HomeFragment
import com.niranjan.mycoolapp.fragment.InfoFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // lateinit var button: Button

    lateinit var binding : ActivityMainBinding
    private var fragmentStack = ArrayList<Fragment?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pushFragment(HomeFragment())
    }

    private fun pushFragment(newFragment: Fragment){
        fragmentStack.clear()
        supportFragmentManager.popBackStack(
            null,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        supportFragmentManager
            .beginTransaction().replace(R.id.fragment_container, newFragment)
            .addToBackStack(null).commit()
    }

    fun pushInfoFragment(){
        pushFragment(InfoFragment())
    }

    fun pushBoxFragment(){
        pushFragment(BoxFragment())
    }
}
