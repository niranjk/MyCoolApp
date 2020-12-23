package com.niranjan.mycoolapp

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.niranjan.mycoolapp.databinding.ActivityMainBinding
import com.niranjan.mycoolapp.fragment.BoxFragment
import com.niranjan.mycoolapp.fragment.HomeFragment
import com.niranjan.mycoolapp.fragment.InfoFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // lateinit var button: Button

    lateinit var bindingMain: ActivityMainBinding

    private var fragmentStack = ArrayList<Fragment?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // first find the navController from your navigation host fragment
        val navController = this.findNavController(R.id.navigationHost)
        // second link the navController to action bar
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // find navController
        val navController = this.findNavController(R.id.navigationHost)
        return navController.navigateUp()
    }
}
