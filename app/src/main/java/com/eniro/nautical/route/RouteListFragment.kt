package com.eniro.nautical.route

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentRouteListBinding
import com.eniro.nautical.util.BaseFragment

class RouteListFragment: BaseFragment<FragmentRouteListBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentRouteListBinding {
        return FragmentRouteListBinding.inflate(inflater, container, false)
    }
}