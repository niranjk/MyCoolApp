package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.niranjan.mycoolapp.R
import kotlinx.android.synthetic.main.fragment_gamewon.*


class GamewonFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gamewon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = arguments?.let { GamewonFragmentArgs.fromBundle(it) }
        correct_answer.text = args?.ans?: "****"
    }

}