package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.niranjan.mycoolapp.R
import com.niranjan.mycoolapp.databinding.FragmentRulesBinding


class RulesFragment : Fragment() {

    lateinit var rulesbinding : FragmentRulesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rulesbinding = DataBindingUtil.inflate(inflater,R.layout.fragment_rules, container, false)
        return rulesbinding.root
    }



}