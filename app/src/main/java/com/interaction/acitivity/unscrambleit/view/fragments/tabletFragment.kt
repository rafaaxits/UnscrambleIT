package com.interaction.acitivity.unscrambleit.view.fragments


import android.content.Intent
import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.interaction.acitivity.unscrambleit.R
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_LevelsScreen


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class tabletFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tablet, container, false)
        var btnRank = view.findViewById<Button>(R.id.btnRank)
        var btnBeginner = view.findViewById<Button>(R.id.btnBeginner)
        var btnIntermidiate = view.findViewById<Button>(R.id.btnIntermidiate)
        var btnAdvanced = view.findViewById<Button>(R.id.btnAdvanced)
        btnRank.setOnClickListener(){
            val fragmentManager2 = getFragmentManager()
            val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
            val myfragment2 = rankingFragment()
            fragmentTransaction2.replace(R.id.container1, myfragment2)
            fragmentTransaction2.commit()
        }

        btnBeginner.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_LevelsScreen::class.java)
            intent.putExtra("level", "Beginner")
            startActivity(intent)
        }

        btnIntermidiate.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_LevelsScreen::class.java)
            intent.putExtra("level", "Intermidiate")
            startActivity(intent)
        }

        btnAdvanced.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_LevelsScreen::class.java)
            intent.putExtra("level", "Advanced")
            startActivity(intent)
        }
        return view
    }


}
