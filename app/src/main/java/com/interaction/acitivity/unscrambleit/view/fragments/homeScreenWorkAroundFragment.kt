package com.interaction.acitivity.unscrambleit.view.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.interaction.acitivity.unscrambleit.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class homeScreenWorkAroundFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home_screen_work_around)
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        val myfragment = homeFragment()
        fragmentTransaction.replace(R.id.container1, myfragment)
        fragmentTransaction.commit()

        val fragmentManager2 = getFragmentManager()
        val fragmentTransaction2 = fragmentManager2!!.beginTransaction()
        val myfragment2 = rankingFragment()
        fragmentTransaction2.replace(R.id.container2, myfragment2)
        fragmentTransaction2.commit()
    }


}
