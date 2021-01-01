package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.niranjan.mycoolapp.R
import com.niranjan.mycoolapp.databinding.FragmentPlayBinding
import com.niranjan.mycoolapp.utils.CoolConstants
import com.niranjan.mycoolapp.viewmodel.PlayViewModel
import kotlinx.android.synthetic.main.fragment_play.*
import timber.log.Timber

class PlayFragment : Fragment() {

    lateinit var playBinding : FragmentPlayBinding
    private lateinit var viewModel: PlayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        playBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_play, container, false)
        Timber.i("ViewModelProvider called..... ")
        viewModel = ViewModelProvider(this).get(PlayViewModel::class.java)
        // viewModel = PlayViewModel()
        return playBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submitBtn.setOnClickListener {
            checkAnswers(it)
        }
        /* classical arguments passing
        val name = arguments?.getString(CoolConstants.ARGUMENTS_KEY_INT) // 0
        val number = arguments?.getInt(CoolConstants.ARGUMENTS_KEY_INT) // null

         */

    }


    fun checkAnswers(view: View){
        // get text of selected radio button
        val answer = when {
            radioBtn1.isChecked -> radioBtn1.text
            radioBtn2.isChecked -> radioBtn2.text
            radioBtn3.isChecked -> radioBtn3.text
            radioBtn4.isChecked -> radioBtn4.text
            else -> ""
        }

        // conditional navigation
        if (answer.equals("Rome")){
            view.findNavController().navigate(PlayFragmentDirections.actionPlayFragmentToGamewonFragment(answer as String))
        }else{
            view.findNavController().navigate(PlayFragmentDirections.actionPlayFragmentToGamelostFragment(answer as String))
        }

    }
}