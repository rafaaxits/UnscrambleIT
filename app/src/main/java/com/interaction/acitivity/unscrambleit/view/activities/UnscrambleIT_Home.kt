package com.interaction.acitivity.unscrambleit.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.interaction.acitivity.unscrambleit.*
import com.interaction.acitivity.unscrambleit.view.fragments.homeScreenWorkAroundFragment
import kotlinx.android.synthetic.main.activity_unscramble_it__home.*

class UnscrambleIT_Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__home)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        val validate = resources.getBoolean(R.bool.isTablet)
        if(validate) {
            if(savedInstanceState == null){
                val intent = Intent(this, homeScreenWorkAroundFragment::class.java)
                startActivity(intent)
            }
        }
        btnRank.setOnClickListener(){
                val intent = Intent(this, UnscrambleIT_Ranking::class.java)
                startActivity(intent)
        }

        btnBeginner.setOnClickListener(){
            val intent = Intent(this, UnscrambleIT_BeginnerLevels::class.java)
            startActivity(intent)
        }

        btnIntermidiate.setOnClickListener(){
            val intent = Intent(this, UnscrambleIT_IntermidiateLevels::class.java)
            startActivity(intent)
        }

        btnAdvanced.setOnClickListener(){
            val intent = Intent(this, UnscrambleIT_AdvancedLevels::class.java)
            startActivity(intent)
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
