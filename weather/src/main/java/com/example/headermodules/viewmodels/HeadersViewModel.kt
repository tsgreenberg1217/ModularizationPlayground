package com.example.headermodules.viewmodels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class HEADER { ONE, TWO }
class HeadersViewModel : ViewModel(){
    val highlightedHeader: MutableLiveData<HEADER> by lazy { MutableLiveData(HEADER.ONE) }
    fun navigateToHeader(header: HEADER) {
        highlightedHeader.value = header
    }
}