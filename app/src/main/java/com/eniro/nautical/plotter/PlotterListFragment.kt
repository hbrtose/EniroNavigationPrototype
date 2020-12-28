package com.eniro.nautical.plotter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentPlotterListBinding
import com.eniro.nautical.util.BaseFragment

class PlotterListFragment: BaseFragment<FragmentPlotterListBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentPlotterListBinding {
        return FragmentPlotterListBinding.inflate(inflater, container, false)
    }
}