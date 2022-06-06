package com.example.expandablelistwithviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        val data = getData()
        viewPager.adapter = TabAdapter(data, supportFragmentManager, lifecycle)

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.text = data[position].name
        }.attach()
    }

    private fun getData(): List<Tab> {
        val tabs: MutableList<Tab> =  ArrayList()

        for (i in 1..4) {
            val tab = Tab(i, "Tab $i", getItems())
            tabs.add(tab)
        }
        return tabs
    }

    private fun getItems(): List<Item> {
        val items: MutableList<Item> =  ArrayList()

        for (i in 1..3) {
            val item = Item(i, "Item $i", getChildItems())
            items.add(item)
        }
        return items
    }

    private fun getChildItems(): List<Item> {
        val items: MutableList<Item> =  ArrayList()

        for (i in 1..2) {
            val item = Item(i, "Child item $i", null)
            items.add(item)
        }
        return items
    }
}