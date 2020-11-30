package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.niranjan.mycoolapp.R
import com.niranjan.mycoolapp.databinding.FragmentInfoBinding
import com.niranjan.mycoolapp.model.Person

class InfoFragment : Fragment() {


    var person = Person("NIran", "Janky")
    lateinit var infoBinding : FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        infoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)
        return infoBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateDataBindingObject()
    }

    fun updateDataBindingObject(){
        infoBinding.person = person
    }

}