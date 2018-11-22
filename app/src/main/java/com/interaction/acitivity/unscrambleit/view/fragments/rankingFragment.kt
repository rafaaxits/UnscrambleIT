package com.interaction.acitivity.unscrambleit.view.fragments


import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.interaction.acitivity.unscrambleit.beans.Player
import com.interaction.acitivity.unscrambleit.view.adapters.PlayerAdapter
import com.interaction.acitivity.unscrambleit.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class rankingFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<PlayerAdapter.MyViewHolder>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mPlayers: ArrayList<Player>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)
        viewManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager
        populatePlayersRanking()
        viewAdapter = PlayerAdapter(mPlayers, activity)

        recyclerView = view.findViewById<RecyclerView>(R.id.ranking_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

        }
        return view
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
