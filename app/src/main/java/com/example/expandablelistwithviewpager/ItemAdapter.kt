package com.example.expandablelistwithviewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter(private val context: Context, private val data: List<Item>): BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return data.count()
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        if (data[groupPosition].child == null) {
            return 0
        }
        return data[groupPosition].child!!.count()
    }

    override fun getGroup(groupPosition: Int): Any {
        return data[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        if (data[groupPosition].child == null) {
            return Any()
        }
        return data[groupPosition].child!![childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return (groupPosition.toString() + childPosition.toString()).toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val model = getGroup(groupPosition) as Item
        val view = convertView ?: run {
            val inflater = LayoutInflater.from(context)
            inflater.inflate(R.layout.view_item, parent, false)!!
        }

        val name = view.findViewById<TextView>(R.id.name)
        name.text = model.name

        val groupIndicator = view.findViewById<ImageView>(R.id.groupIndicator)
        groupIndicator.isSelected = isExpanded

        return view
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val model = getChild(groupPosition, childPosition) as Item

        val view = convertView ?: run {
            val inflater = LayoutInflater.from(context)
            inflater.inflate(R.layout.view_item, parent, false)!!
        }

        val name = view.findViewById<TextView>(R.id.name)
        val groupIndicator = view.findViewById<ImageView>(R.id.groupIndicator)
        groupIndicator.visibility = View.INVISIBLE

        name.text = model.name

        return view
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }
}