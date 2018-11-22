package com.interaction.acitivity.unscrambleit.view.fragments

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import com.interaction.acitivity.unscrambleit.*
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_AdvancedLevels
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_BeginnerLevels
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_IntermidiateLevels
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_Ranking


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
class homeFragment : Fragment() {

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
            /*if(container != null)
                if(savedInstanceState == null){
                    var fragment = PlayerListFragment()
                    supportFragmentManager.beginTransaction().add(
                            R.id.list,
                            fragment).commit()
                }
            }else {*/
            val intent = Intent(activity, UnscrambleIT_Ranking::class.java)
            startActivity(intent)
            //}
        }

        btnBeginner.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_BeginnerLevels::class.java)
            startActivity(intent)
        }

        btnIntermidiate.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_IntermidiateLevels::class.java)
            startActivity(intent)
        }

        btnAdvanced.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_AdvancedLevels::class.java)
            startActivity(intent)
        }
        return view;
    }
}
