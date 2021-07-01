package com.rajneesh.echoplayer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajneesh.echoplayer.R
import com.rajneesh.echoplayer.model.player

class AllsongRecyclerAdapter(val context: Context, val itemList: Array<player>): RecyclerView.Adapter<AllsongRecyclerAdapter.allsongsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): allsongsViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_allsongs_single_row,parent,false)

        return allsongsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: allsongsViewHolder, position: Int) {

        val text = itemList[position]
        holder.txtTrackTitle.text =
        holder.txtArtiest.text =
    }

    class allsongsViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtTrackTitle :TextView = view.findViewById(R.id.txtTrackTitile)
        val txtArtiest :TextView = view.findViewById(R.id.txtArtiest)

    }
}