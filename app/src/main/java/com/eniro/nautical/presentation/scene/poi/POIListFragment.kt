package com.eniro.nautical.presentation.scene.poi

import com.eniro.nautical.R
import com.eniro.nautical.databinding.FragmentPoiListBinding
import com.eniro.nautical.presentation.base.BaseFragment2
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class POIListFragment : BaseFragment2<FragmentPoiListBinding, POIListViewModel>(
    POIListViewModel::class,
    FragmentPoiListBinding::bind,
    R.layout.fragment_poi_list
) {

    override fun onBind(binding: FragmentPoiListBinding) {
        binding.poi.text = "POI"
    }
}