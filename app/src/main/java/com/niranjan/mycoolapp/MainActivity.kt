package com.niranjan.mycoolapp

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.niranjan.mycoolapp.databinding.ActivityMainBinding
import com.niranjan.mycoolapp.fragment.BoxFragment
import com.niranjan.mycoolapp.fragment.HomeFragment
import com.niranjan.mycoolapp.fragment.InfoFragment
import com.niranjan.mycoolapp.utils.CoolTimer
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // lateinit var button: Button

    lateinit var bindingMain: ActivityMainBinding

    private var fragmentStack = ArrayList<Fragment?>()

    lateinit var drawerLayout: DrawerLayout

    lateinit var timer: CoolTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // initialize drawerlayout from binding
        drawerLayout = bindingMain.drawerLayout
        // first find the navController from your navigation host fragment
        val navController = this.findNavController(R.id.navigationHost)

        // initalize timer
        // timer = CoolTimer(this.lifecycle)

        // second link the navController to action bar
        // we have to add the drawerLayout as second parameter
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        // unlock the swipe oly on start Destination
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == controller.graph.startDestination){
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
        // hook the navigation UI up to the navigation view (navView)
        NavigationUI.setupWithNavController(bindingMain.navView, navController)
        Log.i("MainActivity", "Default Android Logging API : onCreate called")
        Timber.i("Timber Logging API : onCreate called ")
    }

    override fun onSupportNavigateUp(): Boolean {
        // find navController
        val navController = this.findNavController(R.id.navigationHost)
        // replace navController.navigateUp() with NavigationUI.navigateUP with drawerLayout parameter
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    // lifecycle methods

    override fun onStart() {
        super.onStart()
        Log.i("MainActivity"," Default Android Logging API : onStart called ")
        Timber.i("Timber Logging : onStart called ")
        // timer.startTimer()
    }

    override fun onResume() {
        super.onResume()
        Timber.i("Timber Logging : onResume called ")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("Timber Logging : onPause called ")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("Timber Logging : onStop called ")
        // timer.stopTimer()
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("Timber Logging : onDestroy called ")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("Timber Logging : onRestart called ")
    }
}
