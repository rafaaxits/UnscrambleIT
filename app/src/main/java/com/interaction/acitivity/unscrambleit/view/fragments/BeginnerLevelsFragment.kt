package com.interaction.acitivity.unscrambleit.view.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.interaction.acitivity.unscrambleit.R
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_beginner_level1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BeginnerLevelsFragment : android.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_beginner_levels, container, false)
        var btnFirstLevel = view.findViewById<Button>(R.id.btnFirstLevel)
        btnFirstLevel.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            startActivity(intent)
        }
        return view
    }


}
