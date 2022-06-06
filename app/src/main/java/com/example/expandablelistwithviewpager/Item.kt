package com.example.expandablelistwithviewpager

data class Item(
    val id: Int,
    val name: String,
    val child: List<Item>?
)
