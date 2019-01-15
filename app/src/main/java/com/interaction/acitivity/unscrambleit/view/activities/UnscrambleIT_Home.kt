package com.interaction.acitivity.unscrambleit.view.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.facebook.CallbackManager
import com.interaction.acitivity.unscrambleit.*
import com.interaction.acitivity.unscrambleit.view.fragments.homeFragment
//import com.interaction.acitivity.unscrambleit.view.fragments.homeFragmentLand
import com.interaction.acitivity.unscrambleit.view.fragments.rankingFragment
import com.interaction.acitivity.unscrambleit.view.fragments.tabletFragment
import android.view.*
import android.content.Intent




class UnscrambleIT_Home : AppCompatActivity() {
    var callbackManager = CallbackManager.Factory.create();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__home)

        val validate = resources.getBoolean(R.bool.isTablet)
        if(validate) {
            if(savedInstanceState == null){
                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                val myFragmentTablet = tabletFragment()
                fragmentTransaction.replace(R.id.container1, myFragmentTablet)
                fragmentTransaction.commit()

                val fragmentManager2 = getFragmentManager()
                val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
                val myFragmentRanking = rankingFragment()
                fragmentTransaction2.replace(R.id.container2, myFragmentRanking)
                fragmentTransaction2.commit()
            }
        } else {
            if(savedInstanceState == null) {
                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                val myFragmentPortrait = homeFragment()
                fragmentTransaction.replace(R.id.container1, myFragmentPortrait)
                fragmentTransaction.commit()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return false
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = this.menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    /*override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        return false
    }*/
}
