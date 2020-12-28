package com.eniro.nautical.poi

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentPoiListBinding
import com.eniro.nautical.util.BaseFragment

class POIListFragment: BaseFragment<FragmentPoiListBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentPoiListBinding {
        return FragmentPoiListBinding.inflate(inflater, container, false)
    }
}