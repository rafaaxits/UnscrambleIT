package com.interaction.acitivity.unscrambleit.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.interaction.acitivity.unscrambleit.R
import com.interaction.acitivity.unscrambleit.view.fragments.LoseFragment
import com.interaction.acitivity.unscrambleit.view.fragments.WinFragment

class UnscrambleIT_GameResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__game_result)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent;
        var level = intent.getStringExtra("level")
        var result = intent.getStringExtra("result")
        if(savedInstanceState == null) {

            if(result.equals("YOU WIN")){
                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                val myWinFragmentPortrait = WinFragment()
                val args = Bundle()
                args.putString("level", level)
                myWinFragmentPortrait.arguments = args
                fragmentTransaction.replace(R.id.container1, myWinFragmentPortrait)
                fragmentTransaction.commit()
            } else {
                val fragmentManager = fragmentManager
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                val myLoseFragmentPortrait = LoseFragment()
                val args = Bundle()
                args.putString("level", level)
                myLoseFragmentPortrait.arguments = args
                fragmentTransaction.replace(R.id.container1, myLoseFragmentPortrait)
                fragmentTransaction.commit()
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
