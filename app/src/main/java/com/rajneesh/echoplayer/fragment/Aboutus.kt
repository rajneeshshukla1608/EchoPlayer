package com.rajneesh.echoplayer.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rajneesh.echoplayer.R


class Aboutus : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this com.rajneesh.echoplayer.fragment
        val view = inflater.inflate(R.layout.fragment_aboutus, container, false)
        return view

    }
}