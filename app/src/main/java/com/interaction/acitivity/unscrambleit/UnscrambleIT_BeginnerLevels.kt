package com.interaction.acitivity.unscrambleit

import android.content.Intent
import android.view.MenuItem
import android.view.Menu
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class UnscrambleIT_BeginnerLevels : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__beginner_levels)

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
