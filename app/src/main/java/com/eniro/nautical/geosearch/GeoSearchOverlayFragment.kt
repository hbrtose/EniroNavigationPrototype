package com.eniro.nautical.geosearch

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentGeosearchOverlayBinding
import com.eniro.nautical.util.BaseFragment

class GeoSearchOverlayFragment: BaseFragment<FragmentGeosearchOverlayBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentGeosearchOverlayBinding {
        return FragmentGeosearchOverlayBinding.inflate(inflater, container, false)
    }
}