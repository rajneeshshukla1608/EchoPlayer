package com.rajneesh.echoplayer.fragment

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rajneesh.echoplayer.R
import com.rajneesh.echoplayer.adapter.AllsongRecyclerAdapter


class Allsongs : Fragment() {

    lateinit var recyclerAdapter: AllsongRecyclerAdapter

    lateinit var recyclerallsongs: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Inflate the layout for this com.rajneesh.echoplayer.fragment
        val view = inflater.inflate(R.layout.fragment_allsongs, container, false)

        recyclerallsongs = view.findViewById(R.id.recyclerallSongs)

        layoutManager = LinearLayoutManager(activity)

       recyclerAdapter =  AllsongRecyclerAdapter(activity as Context,  )

        recyclerallsongs.adapter = recyclerAdapter

        recyclerallsongs.layoutManager = layoutManager

        return view
    }
}
