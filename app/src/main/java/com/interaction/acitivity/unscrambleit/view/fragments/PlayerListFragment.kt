package com.interaction.acitivity.unscrambleit.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.interaction.acitivity.unscrambleit.beans.Player
import com.interaction.acitivity.unscrambleit.view.adapters.PlayerAdapter
import com.interaction.acitivity.unscrambleit.R


class PlayerListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var mPlayers: ArrayList<Player>
    private lateinit var viewAdapter: RecyclerView.Adapter<PlayerAdapter.MyViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager
        populatePlayersRanking()
        viewAdapter = PlayerAdapter(mPlayers, context)
        val view = inflater.inflate(R.layout.activity_unscramble_it__ranking, null)
        recyclerView = view.findViewById(R.id.ranking_recycler_view)
        recyclerView.adapter = viewAdapter
        recyclerView.layoutManager = viewManager

        return view
        /*Minha home é o list fragment, e isso aqui é meu detalhe*/
    }

    fun populatePlayersRanking(){
        mPlayers = ArrayList()
        for (i in 0..199) {
            mPlayers.add(Player("Rafael", "3232", i + 1))
            mPlayers.add(Player("Nycolas", "3232", i + 1))
            mPlayers.add(Player("Vanilson", "5873", i + 1))
            mPlayers.add(Player("Banilson", "25453", i + 1))
        }
    }
}