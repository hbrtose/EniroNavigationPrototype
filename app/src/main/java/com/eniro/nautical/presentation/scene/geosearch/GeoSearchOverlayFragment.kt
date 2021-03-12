package com.eniro.nautical.presentation.scene.geosearch

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentGeosearchOverlayBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GeoSearchOverlayFragment: BaseViewBindingFragment<FragmentGeosearchOverlayBinding, GeoSearchOverlayViewModel>(GeoSearchOverlayViewModel::class) {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentGeosearchOverlayBinding {
        return FragmentGeosearchOverlayBinding.inflate(inflater, container, false)
    }
}