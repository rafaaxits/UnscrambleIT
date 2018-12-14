package com.interaction.acitivity.unscrambleit.view.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Surface
import android.view.WindowManager
import com.interaction.acitivity.unscrambleit.R
import com.interaction.acitivity.unscrambleit.view.fragments.*

class UnscrambleIT_LevelsScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__levels_screen)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val intent = intent;
        var level = intent.getStringExtra("level")
        val validate = resources.getBoolean(R.bool.isTablet)
        if(validate) {
            if(savedInstanceState == null){
                if(level.equals("Beginner")) {
                    val fragmentManager2 = getFragmentManager()
                    val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
                    val myFragmentBeginnerLevels = BeginnerLevelsFragment()
                    fragmentTransaction2.replace(R.id.container1, myFragmentBeginnerLevels)
                    fragmentTransaction2.commit()
                } else if(level.equals("Intermidiate")){
                    val fragmentManager2 = getFragmentManager()
                    val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
                    val myFragmentIntermidiateLevels = IntermidiateLevelsFragment()
                    fragmentTransaction2.replace(R.id.container1, myFragmentIntermidiateLevels)
                    fragmentTransaction2.commit()
                } else if(level.equals("Advanced")){
                    val fragmentManager2 = getFragmentManager()
                    val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
                    val myFragmentAdvancedLevels = AdvancedLevelsFragment()
                    fragmentTransaction2.replace(R.id.container1, myFragmentAdvancedLevels)
                    fragmentTransaction2.commit()
                }
            }
        } else {
            if(savedInstanceState == null) {
                if(level.equals("Beginner")) {
                    val fragmentManager = fragmentManager
                    val fragmentTransaction = fragmentManager!!.beginTransaction()
                    val myFragmentPortrait = BeginnerLevelsFragment()
                    fragmentTransaction.replace(R.id.container1, myFragmentPortrait)
                    fragmentTransaction.commit()
                } else if(level.equals("Intermidiate")){
                    val fragmentManager2 = getFragmentManager()
                    val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
                    val myFragmentIntermidiateLevels = IntermidiateLevelsFragment()
                    fragmentTransaction2.replace(R.id.container1, myFragmentIntermidiateLevels)
                    fragmentTransaction2.commit()
                } else if(level.equals("Advanced")){
                    val fragmentManager2 = getFragmentManager()
                    val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
                    val myFragmentAdvancedLevels = AdvancedLevelsFragment()
                    fragmentTransaction2.replace(R.id.container1, myFragmentAdvancedLevels)
                    fragmentTransaction2.commit()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
}
