package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.niranjan.mycoolapp.R
import com.niranjan.mycoolapp.databinding.FragmentGameBinding
import com.niranjan.mycoolapp.viewmodel.GameViewModel

class GameFragment : Fragment() {



    lateinit var gameBinding: FragmentGameBinding

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        gameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

        // instantiate the view model
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        // move this initialization to ViewModel


        initListeners()

        updateScoreText()
        updateSurnameText()
        return gameBinding.root
    }

    private fun initListeners() {
        gameBinding.correctButton.setOnClickListener {
            viewModel.onCorrect()
            updateSurnameText()
            updateScoreText()
        }

        gameBinding.skipButton.setOnClickListener {
            viewModel.onSkip()
            updateSurnameText()
            updateScoreText()
        }
    }

    private fun gameFinished(){
        // findNavController().navigate(GameFragmentDirections.actionGameFragmentToScoreFragment(score))
    }


    // UI Controller methods
    private fun updateSurnameText(){
        gameBinding.wordText.text = viewModel.surname
    }

    private fun updateScoreText(){
        gameBinding.scoreText.text = viewModel.score.toString()
    }

    //...


}