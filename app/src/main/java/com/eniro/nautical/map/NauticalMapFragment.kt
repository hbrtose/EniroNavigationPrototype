package com.eniro.nautical.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.eniro.nautical.databinding.FragmentNauticalMapBinding
import com.eniro.nautical.util.BaseFragment

class NauticalMapFragment: BaseFragment<FragmentNauticalMapBinding>() {

    private val navCoordinatorViewModel: NavCoordinatorViewModel by activityViewModels()

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentNauticalMapBinding {
        return FragmentNauticalMapBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.drawerOpener.setOnClickListener { navCoordinatorViewModel.openDrawer() }
    }
}