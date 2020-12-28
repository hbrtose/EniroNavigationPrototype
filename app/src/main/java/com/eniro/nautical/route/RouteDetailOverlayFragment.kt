package com.eniro.nautical.route

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentRouteDetailOverlayBinding
import com.eniro.nautical.util.BaseFragment

class RouteDetailOverlayFragment: BaseFragment<FragmentRouteDetailOverlayBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentRouteDetailOverlayBinding {
        return FragmentRouteDetailOverlayBinding.inflate(inflater, container, false)
    }
}