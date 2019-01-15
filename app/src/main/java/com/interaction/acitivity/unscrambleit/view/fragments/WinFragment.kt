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
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_beginner_level1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class WinFragment : android.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_win, container, false)
        var btnBack = view.findViewById<Button>(R.id.btnBack)
        var btnNext = view.findViewById<Button>(R.id.btnNext)
        val args = arguments
        var level = args.getString("level")
        btnBack.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            intent.putExtra("level", level)
            startActivity(intent)
        }

        btnNext.setOnClickListener(){
            var levelInt = level.last().toString().toInt()
            var generateLevel = level.slice(0..level.length-2)
            if(levelInt > 4){
                if(generateLevel == "beginner"){
                    val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
                    intent.putExtra("level", "intermidiate1")
                    startActivity(intent)
                } else if(generateLevel == "intermidiate"){
                    val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
                    intent.putExtra("level", "advanced1")
                    startActivity(intent)
                } else {
                    val intent = Intent(activity, UnscrambleIT_Home::class.java)
                    startActivity(intent)
                }
            } else{
                levelInt++
                val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
                intent.putExtra("level", generateLevel + levelInt.toString())
                startActivity(intent)
            }
        }
        return view
    }


}
