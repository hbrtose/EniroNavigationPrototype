package com.eniro.nautical.presentation.scene.plotter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentPlotterListBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlotterListFragment: BaseViewBindingFragment<FragmentPlotterListBinding, PlotterListViewModel>(PlotterListViewModel::class) {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentPlotterListBinding {
        return FragmentPlotterListBinding.inflate(inflater,  container, false)
    }
}