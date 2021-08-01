package com.example.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {

    @TypeConverter
    fun fromStringToListOfString(json: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(json, listType)
    }
    @TypeConverter
    fun fromListOfStringToString(list: List<String>): String = Gson().toJson(list)

}