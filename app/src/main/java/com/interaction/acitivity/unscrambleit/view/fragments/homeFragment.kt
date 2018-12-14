package com.interaction.acitivity.unscrambleit.view.fragments

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import com.interaction.acitivity.unscrambleit.*
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_LevelsScreen


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [homeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
public class homeFragment : android.app.Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        var btnRank = view.findViewById<Button>(R.id.btnRank)
        var btnBeginner = view.findViewById<Button>(R.id.btnBeginner)
        var btnIntermidiate = view.findViewById<Button>(R.id.btnIntermidiate)
        var btnAdvanced = view.findViewById<Button>(R.id.btnAdvanced)

        btnRank.setOnClickListener(){
            val fragmentManager2 = getFragmentManager()
            val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
            val myFragmentRanking = rankingFragment()
            fragmentTransaction2.replace(R.id.container1, myFragmentRanking)
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
        return view;
    }

    fun getScreenOrientation(context: Context): String {
        val screenOrientation = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.orientation
        when (screenOrientation) {
            Surface.ROTATION_0 -> return "android portrait screen"
            Surface.ROTATION_90 -> return "android landscape screen"
            Surface.ROTATION_180 -> return "android reverse portrait screen"
            else -> return "android reverse landscape screen"
        }
    }
}
