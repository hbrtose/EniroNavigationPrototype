package com.eniro.nautical.presentation.scene.poi

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentPoiListBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class POIListFragment: BaseViewBindingFragment<FragmentPoiListBinding, POIListViewModel>(POIListViewModel::class) {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentPoiListBinding {
        return FragmentPoiListBinding.inflate(inflater, container, false)
    }
}