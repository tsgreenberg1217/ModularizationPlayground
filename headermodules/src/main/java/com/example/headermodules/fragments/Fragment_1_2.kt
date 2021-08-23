package com.example.headermodules.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.headermodules.baseClasses.BaseFragment
import com.example.headermodules.R
import com.example.headermodules.databinding.Fragment12Binding
import com.example.headermodules.viewmodels.HEADER
import com.example.headermodules.viewmodels.HeadersViewmodel

class Fragment_1_2 : BaseFragment(R.layout.fragment_1_2) {
    private val headerViewModel: HeadersViewmodel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Fragment12Binding.bind(view)
        Fragment12Binding.bind(view).frag12Btn.setOnClickListener {
            headerViewModel.navigateToHeader(HEADER.TWO)
        }

    }
}