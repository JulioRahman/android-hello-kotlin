package com.julio.hellokotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = main_list
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerViewAdapter(this, items)
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.team_name)
        val imageBase = resources.getString(R.string.team_badge_base)
        val image = resources.getStringArray(R.array.team_bagde)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], imageBase + image[i]))
        }
    }
}
