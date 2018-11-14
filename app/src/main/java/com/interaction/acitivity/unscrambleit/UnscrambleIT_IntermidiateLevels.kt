package com.interaction.acitivity.unscrambleit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class UnscrambleIT_IntermidiateLevels : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__intermidiate_levels)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, UnscrambleIT_Home::class.java)
        startActivity(intent)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
}
