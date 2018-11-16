package com.interaction.acitivity.unscrambleit

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem

class UnscrambleIT_Ranking : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<PlayerAdapter.MyViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mPlayers: ArrayList<Player>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unscramble_it__ranking)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        viewManager = LinearLayoutManager(this) as RecyclerView.LayoutManager
        populatePlayersRanking()
        viewAdapter = PlayerAdapter(mPlayers, this)

         recyclerView = findViewById<RecyclerView>(R.id.ranking_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, UnscrambleIT_Home::class.java)
        startActivity(intent)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    fun populatePlayersRanking(){
        mPlayers = ArrayList()
        for (i in 0..199) {
            mPlayers.add(Player("Rafael", "3232", i+1))
            mPlayers.add(Player("Nycolas", "3232", i+1))
            mPlayers.add(Player("Vanilson", "5873", i+1))
            mPlayers.add(Player("Banilson", "25453", i+1))
        }
    }
}

