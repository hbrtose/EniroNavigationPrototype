package com.eniro.nautical.map

import com.eniro.nautical.util.BaseViewModel
import com.eniro.nautical.util.SingleLiveEvent

abstract class OverlayViewModel: BaseViewModel() {

    protected val command = SingleLiveEvent<String>()

    abstract fun hide(hide: Boolean)
}