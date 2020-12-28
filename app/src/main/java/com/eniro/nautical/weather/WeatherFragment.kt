package com.eniro.nautical.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentWeatherBinding
import com.eniro.nautical.util.BaseFragment

class WeatherFragment: BaseFragment<FragmentWeatherBinding>() {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentWeatherBinding {
        return FragmentWeatherBinding.inflate(inflater, container, false)
    }
}