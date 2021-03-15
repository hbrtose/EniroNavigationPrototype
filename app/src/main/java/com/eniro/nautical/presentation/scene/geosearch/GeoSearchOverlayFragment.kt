package com.eniro.nautical.presentation.scene.geosearch

import com.eniro.nautical.R
import com.eniro.nautical.databinding.FragmentGeosearchOverlayBinding
import com.eniro.nautical.presentation.base.BaseFragment2
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GeoSearchOverlayFragment : BaseFragment2<FragmentGeosearchOverlayBinding, GeoSearchOverlayViewModel>(
    GeoSearchOverlayViewModel::class,
    FragmentGeosearchOverlayBinding::bind,
    R.layout.fragment_geosearch_overlay
)