package com.eniro.nautical.presentation.scene.route.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentRouteListBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RouteListFragment: BaseViewBindingFragment<FragmentRouteListBinding, RouteListViewModel>(RouteListViewModel::class) {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentRouteListBinding {
        return FragmentRouteListBinding.inflate(inflater, container, false)
    }
}