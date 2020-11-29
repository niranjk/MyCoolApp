package com.niranjan.mycoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRandomIconForImageView()
    }

    private fun setRandomIconForImageView() {
        // button = findViewById(R.id.generateBtn)
        generateBtn.setOnClickListener {

            var randomNumber = Random.nextInt(4)+1
            var drawable= when(randomNumber){
                1 -> R.drawable.ic_random_1
                2 -> R.drawable.ic_random_2
                3 -> R.drawable.ic_random_3
                4 -> R.drawable.ic_random_4
                else -> R.drawable.ic_launcher_background
            }
            imageView.setImageResource(drawable)
            Toast.makeText(this, "Random Icon Generated.", Toast.LENGTH_SHORT).show()
        }
    }
}