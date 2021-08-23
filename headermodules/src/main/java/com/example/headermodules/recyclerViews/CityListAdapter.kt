package com.example.headermodules.recyclerViews

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.data_utility.models.CityWeatherResult
import com.example.headermodules.R

class CityListAdapter(val ctx: Context, val list: List<CityWeatherResult>) : BaseAdapter() {
    var counter: Int = 0
    override fun getCount(): Int = list.size

    override fun getItem(p0: Int): Any = list[p0]

    override fun getItemId(p0: Int): Long = (++counter).toLong()

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, parent: ViewGroup?): View {
        return (ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
            R.layout.viewholder_weather,parent,false
        )
    }

}
