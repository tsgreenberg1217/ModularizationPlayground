package com.example.headermodules.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class HEADER { ONE, TWO }
class HeadersViewmodel : ViewModel() {
    val highlightedHeader: MutableLiveData<HEADER> by lazy { MutableLiveData(HEADER.ONE) }
    fun navigateToHeader(header: HEADER) {
        highlightedHeader.value = header
    }
}