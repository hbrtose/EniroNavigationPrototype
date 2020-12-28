package com.eniro.nautical.map

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.eniro.nautical.util.BaseViewModel
import com.eniro.nautical.util.SingleLiveEvent

class NavCoordinatorViewModel @ViewModelInject constructor(
    //@Assisted private val savedStateHandle: SavedStateHandle
): BaseViewModel() {

    companion object {
        const val POP_BACKSTACK = -11
    }

    val navigateToOverlay = SingleLiveEvent<Int>()
    val drawerOpen = SingleLiveEvent<Boolean>()

    fun navigateToOverlay(action: Int) {
        navigateToOverlay.value = action
    }

    fun showPois() {

    }

    fun hidePois() {

    }

    fun removeOverlays() {
        navigateToOverlay.value = POP_BACKSTACK
    }

    fun openDrawer() {
        drawerOpen.value = true
    }

    fun closeDrawer() {
        drawerOpen.value = false
    }
}