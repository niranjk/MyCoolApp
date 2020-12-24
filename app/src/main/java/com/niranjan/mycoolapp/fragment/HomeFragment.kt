package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.niranjan.mycoolapp.R
import com.niranjan.mycoolapp.databinding.FragmentHomeBinding
import com.niranjan.mycoolapp.utils.CoolConstants
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,  false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRandomIconForImageView()
        /* classical argument passing
        bundle = Bundle()
        bundle.putString(CoolConstants.ARGUMENTS_KEY_STRING, "valueString")
         */
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }


    private fun setRandomIconForImageView() {
        // button = findViewById(R.id.generateBtn)

        binding.floatingActionButton.setOnClickListener { view ->
            // (activity as MainActivity).pushInfoFragment()
            // Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_infoFragment)
            view.findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
        }

        // 2. Kotlin Synthetic Library.
        playBtn.setOnClickListener {
            /* classical arguments passing
            val fragment = PlayFragment()
            fragment.arguments = bundle

             */
            it.findNavController().navigate(R.id.action_homeFragment_to_playFragment)
        }
    }
}