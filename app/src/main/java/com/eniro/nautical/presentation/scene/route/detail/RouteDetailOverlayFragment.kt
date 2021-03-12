package com.eniro.nautical.presentation.scene.route.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentRouteDetailOverlayBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RouteDetailOverlayFragment: BaseViewBindingFragment<FragmentRouteDetailOverlayBinding, RouteDetailOverlayViewModel>(RouteDetailOverlayViewModel::class) {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentRouteDetailOverlayBinding {
        return FragmentRouteDetailOverlayBinding.inflate(inflater, container, false)
    }
}