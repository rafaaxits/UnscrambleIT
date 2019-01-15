package com.interaction.acitivity.unscrambleit.view.fragments


import android.content.Intent
import android.os.Bundle
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
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_Home
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_SignIn
import com.interaction.acitivity.unscrambleit.view.activities.UnscrambleIT_beginner_level1

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class IntermidiateLevelsFragment : android.app.Fragment() {
    var mAuth: FirebaseAuth? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intermidiate_levels, container, false)
        var btnFirstLevel = view.findViewById<Button>(R.id.btnFirstLevel)
        var btnSecondLevel= view.findViewById<Button>(R.id.btnSecondLevel)
        var btnThirdLevel= view.findViewById<Button>(R.id.btnThirdLevel)
        var btnFourthLevel= view.findViewById<Button>(R.id.btnFourthLevel)
        var btnFifthLevel= view.findViewById<Button>(R.id.btnFifthLevel)
        val myToolbar = view.findViewById(R.id.my_toolbar) as Toolbar
        (activity as AppCompatActivity).setSupportActionBar(myToolbar)
        setHasOptionsMenu(true)
        myToolbar.setTitle(null)
        //myToolbar.setOverflowIcon(ContextCompat.getDrawable(activity, R.drawable.menuwhite));
        //myToolbar.inflateMenu(R.menu.menu)
        mAuth = FirebaseAuth.getInstance()

        btnFirstLevel.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            intent.putExtra("level", "intermidiate1")
            startActivity(intent)
        }

        btnSecondLevel.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            intent.putExtra("level", "intermidiate2")
            startActivity(intent)
        }

        btnThirdLevel.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            intent.putExtra("level", "intermidiate3")
            startActivity(intent)
        }

        btnFourthLevel.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            intent.putExtra("level", "intermidiate4")
            startActivity(intent)
        }

        btnFifthLevel.setOnClickListener(){
            val intent = Intent(activity, UnscrambleIT_beginner_level1::class.java)
            intent.putExtra("level", "intermidiate5")
            startActivity(intent)
        }
        return view
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.action_Home -> {
            val intent = Intent(activity, UnscrambleIT_Home::class.java)
            startActivity(intent)
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
