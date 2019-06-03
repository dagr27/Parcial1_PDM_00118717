package com.example.parcial1_00118717

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial1_00118717.dao.matchEntitie

class matchAdapter internal constructor(
    context: Context
):RecyclerView.Adapter<matchAdapter.matchViewHolder>(){
    private val inflater:LayoutInflater = LayoutInflater.from(context)
    private var match = emptyList<matchEntitie>()

    inner class matchViewHolder(matchView: View):RecyclerView.ViewHolder(matchView){
        val t1: EditText=matchView.findViewById(R.id.txtT1)
        val t2: EditText=matchView.findViewById(R.id.txtT2)
        val p1: TextView=matchView.findViewById(R.id.lblscore1)
        val p2: TextView=matchView.findViewById(R.id.lblscore2)
        val date: EditText=matchView.findViewById(R.id.txtDate)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): matchViewHolder {
        val matcView = inflater.inflate(R.layout.match_item, parent, false)
        return matchViewHolder(matcView)
    }

    override fun getItemCount(): Int {
        return match.size
    }

    override fun onBindViewHolder(holder: matchViewHolder, position: Int) {
        val current = match[position]
        holder.t1.setText(current.team1)
        holder.t2.setText(current.team2)
        holder.p1.setText(current.p1.toString())
        holder.t2.setText(current.p2.toString())
        holder.date.setText(current.date.toString())

    }
    internal fun setMatches(match: List<matchEntitie>){
        this.match = match
        notifyDataSetChanged()
    }




}