package com.eniro.nautical.presentation.scene.geosearch

import androidx.lifecycle.MutableLiveData
import com.eniro.nautical.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class GeoSearchOverlayViewModel @Inject constructor(): BaseViewModel() {

    val test = MutableLiveData("GEO")

    fun click() {
        test.value = "${Random.nextInt()}"
    }
}