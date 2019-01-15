package com.interaction.acitivity.unscrambleit.view.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.interaction.acitivity.unscrambleit.R
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_Home
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_LevelsScreen
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_beginner_level1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class LoseFragment : android.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_lose, container, false)
        var btnBack = view.findViewById<Button>(R.id.btnBack)
        var btnMenu = view.findViewById<Button>(R.id.btnNext)
        val args = arguments
        var level = args.getString("level")

        btnBack.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            intent.putExtra("level", level)
            startActivity(intent)
        }

        btnMenu.setOnClickListener(){
            var generateLevel = level.slice(0..level.length-2)
            val intent = Intent(activity, UnscrambleIT_LevelsScreen::class.java)
            intent.putExtra("level", generateLevel.substring(0..0).toUpperCase() + generateLevel.substring(1))
            startActivity(intent)
        }
        return view
    }


}
