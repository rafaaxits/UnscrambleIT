package com.interaction.acitivity.unscrambleit.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.interaction.acitivity.unscrambleit.beans.Player
import com.interaction.acitivity.unscrambleit.R
import kotlinx.android.synthetic.main.ranking_player.view.*

class PlayerAdapter(private val players: ArrayList <Player>,
                    private val context: Context?) : RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val playerName = itemView.txtName
        val points = itemView.txtPoints
        val imgBestPlayer = itemView.imgBestPlayers
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val convertView = LayoutInflater.from(context)
                .inflate(R.layout.ranking_player, parent, false)
        return MyViewHolder(convertView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        if(position == 0){
            val player = players[position]
            holder.imgBestPlayer.setImageResource(R.drawable.first)
            holder.playerName.text = player.nome
            holder.points.text = player.points
        }
        if(position == 1){
            val player = players[position]
            holder.imgBestPlayer.setImageResource(R.drawable.second)
            holder.playerName.text = player.nome
            holder.points.text = player.points
        }
        if(position == 2){
            val player = players[position]
            holder.imgBestPlayer.setImageResource(R.drawable.third)
            holder.playerName.text = player.nome
            holder.points.text = player.points
        }
        else {
            val player = players[position]
            holder.playerName.text = player.nome
            //holder.playerName.margin(left = 30F)
            holder.points.text = player.points
        }
    }

    fun View.margin(left: Float? = null, top: Float? = null, right: Float? = null, bottom: Float? = null) {
        layoutParams<ViewGroup.MarginLayoutParams> {
            left?.run { leftMargin = dpToPx(this) }
            top?.run { topMargin = dpToPx(this) }
            right?.run { rightMargin = dpToPx(this) }
            bottom?.run { bottomMargin = dpToPx(this) }
        }
    }

    inline fun <reified T : ViewGroup.LayoutParams> View.layoutParams(block: T.() -> Unit) {
        if (layoutParams is T) block(layoutParams as T)
    }

    fun View.dpToPx(dp: Float): Int = context.dpToPx(dp)
    fun Context.dpToPx(dp: Float): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()

    override fun getItemCount() = players.size
}
