package com.example.headermodules.recyclerViews

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.data_utility.models.CityWeatherResult
import com.example.headermodules.R

class CityListAdapter(val ctx: Context, val list: List<CityWeatherResult>) : BaseAdapter() {
    val inflater = (ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
    var counter: Int = 0
    override fun getCount(): Int = list.size

    override fun getItem(p0: Int): CityWeatherResult = list[p0]

    override fun getItemId(p0: Int): Long = (++counter).toLong()

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, parent: ViewGroup?): View {
        val element = getItem(p0)
        return inflater.inflate(R.layout.viewholder_weather, parent, false).apply {
            findViewById<TextView>(R.id.weatherVH_city_txt).text = element.name
            findViewById<TextView>(R.id.weatherVH_humidity_txt).text = element.humidity.toString()
        }
    }

}
