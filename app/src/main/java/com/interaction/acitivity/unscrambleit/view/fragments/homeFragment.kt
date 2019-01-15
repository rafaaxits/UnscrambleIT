package com.interaction.acitivity.unscrambleit.view.fragments

import android.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.Toolbar
import android.view.*
import android.widget.Button
import android.widget.Toast
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.interaction.acitivity.unscrambleit.*
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_Home
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_LevelsScreen
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_SignIn
import android.view.MenuInflater




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
@Suppress("UNUSED_LAMBDA_EXPRESSION")
public class homeFragment : android.app.Fragment()  {
    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        var btnBeginner = view.findViewById<Button>(R.id.btnBeginner)
        var btnIntermidiate = view.findViewById<Button>(R.id.btnIntermidiate)
        var btnAdvanced = view.findViewById<Button>(R.id.btnAdvanced)
        val myToolbar = view.findViewById(R.id.my_toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(myToolbar)
        setHasOptionsMenu(true)
        myToolbar.setTitle(null)
        //myToolbar.setOverflowIcon(ContextCompat.getDrawable(activity, R.drawable.menuwhite));
        //myToolbar.inflateMenu(R.menu.menu)
        mAuth = FirebaseAuth.getInstance()

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

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_Ranking -> {
            val fragmentManager2 = getFragmentManager()
            val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
            val myFragmentRanking = rankingFragment()
            fragmentTransaction2.replace(R.id.container1, myFragmentRanking)
            fragmentTransaction2.commit()
            true
        }

        R.id.action_SignOut -> {
            mAuth!!.signOut()
            LoginManager.getInstance().logOut()
            Toast.makeText(activity, R.string.txt_UserDisconnected, Toast.LENGTH_SHORT).show()
            val intent = Intent(activity, UnscrambleIT_SignIn::class.java)
            startActivity(intent)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

   /* override fun onPrepareOptionsMenu(menu: Menu)  {
        menu.clear()
    }*/
}
