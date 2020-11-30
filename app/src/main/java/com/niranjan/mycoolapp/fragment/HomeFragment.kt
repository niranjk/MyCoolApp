package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.niranjan.mycoolapp.MainActivity
import com.niranjan.mycoolapp.R
import com.niranjan.mycoolapp.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.random.Random

class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,  false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRandomIconForImageView()
    }

    private fun setRandomIconForImageView() {
        // button = findViewById(R.id.generateBtn)

        binding.floatingActionButton.setOnClickListener {
            (activity as MainActivity).pushInfoFragment()
        }

        // 2. Kotlin Synthetic Library.
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
            Toast.makeText(context, "Random Icon Generated.", Toast.LENGTH_SHORT).show()
        }
    }
}