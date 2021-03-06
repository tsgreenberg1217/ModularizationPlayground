package com.example.data_utility

import java.lang.Exception

sealed class DataState<out R> {
    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val execption: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}