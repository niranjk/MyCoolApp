package com.niranjan.mycoolapp.fragment

import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.niranjan.mycoolapp.MainActivity
import com.niranjan.mycoolapp.R
import com.niranjan.mycoolapp.databinding.FragmentGamewonBinding
import kotlinx.android.synthetic.main.fragment_gamewon.*
import android.content.Intent as Intent


class GamewonFragment : Fragment() {


    lateinit var bindingGamewon : FragmentGamewonBinding
    var args : GamewonFragmentArgs? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bindingGamewon = DataBindingUtil.inflate(inflater,R.layout.fragment_gamewon, container, false)
        setHasOptionsMenu(true)
        return bindingGamewon.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args = arguments?.let { GamewonFragmentArgs.fromBundle(it) }
        correct_answer.text = args?.ans?: "****"
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.share_menu,menu)

        // check if the activity resolves
        if (getShareIntent().resolveActivity(requireActivity().packageManager) == null ){
            // if not resolved we hide the share menu item
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    private fun getShareIntent() : Intent {
        /*
        classical way of sharing
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain" // "image/JPEG"
        shareIntent.putExtra(Intent.EXTRA_TEXT, args?.ans)
        return shareIntent
         */

        return ShareCompat.IntentBuilder.from(requireActivity())
                .setType("text/plain")
                .setText(getString(R.string.share_success_text))
                .intent
    }

    private fun shareSuccess(){
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }


    fun demoIntent(){

        var explicitIntent = Intent(requireContext(), MainActivity::class.java)

        var implicitIntent = Intent(Intent.ACTION_ASSIST)
    }
}