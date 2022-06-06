package com.example.expandablelistwithviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.fragment.app.Fragment

class MyFragment(): Fragment() {

    private lateinit var data: List<Item>

    constructor(data: List<Item>) : this() {
        this.data = data
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val mainView = inflater.inflate(R.layout.fragment_items_list, container, false)

        val adapter = ItemAdapter(requireContext(), data)
        val listView = mainView.findViewById<ExpandableListView>(R.id.list_view)
        listView.setAdapter(adapter)

        return mainView
    }
}