package com.eniro.nautical.presentation.scene.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.eniro.nautical.databinding.FragmentNauticalMapBinding
import com.eniro.nautical.presentation.base.BaseFragment
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import com.eniro.nautical.presentation.scene.map.NavCoordinatorViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NauticalMapFragment: BaseViewBindingFragment<FragmentNauticalMapBinding, NauticalMapViewModel>(NauticalMapViewModel::class) {

    private val navCoordinatorViewModel: NavCoordinatorViewModel by activityViewModels()

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentNauticalMapBinding {
        return FragmentNauticalMapBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.drawerOpener.setOnClickListener { navCoordinatorViewModel.openDrawer() }
    }
}