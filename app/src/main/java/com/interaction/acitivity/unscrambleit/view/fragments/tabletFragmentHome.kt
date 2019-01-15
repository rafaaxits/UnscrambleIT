package com.interaction.acitivity.unscrambleit.view.fragments


import android.content.Intent
import android.os.Bundle
import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.interaction.acitivity.unscrambleit.R
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_LevelsScreen
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_SignIn


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class tabletFragment : Fragment() {
    var mAuth: FirebaseAuth? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tablet, container, false)
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

        return view
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
