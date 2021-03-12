package com.eniro.nautical.presentation.scene.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentWeatherBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment: BaseViewBindingFragment<FragmentWeatherBinding, WeatherViewModel>(WeatherViewModel::class) {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentWeatherBinding {
        return FragmentWeatherBinding.inflate(inflater, container, false)
    }
}