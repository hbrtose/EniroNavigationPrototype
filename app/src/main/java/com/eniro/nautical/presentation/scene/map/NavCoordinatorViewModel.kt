package com.eniro.nautical.presentation.scene.map

import com.eniro.nautical.presentation.base.BaseViewModel
import com.eniro.nautical.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavCoordinatorViewModel @Inject constructor(): BaseViewModel() {

    companion object {
        const val NAVIGATE_TO_HOME = -11
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
        navigateToOverlay.value = NAVIGATE_TO_HOME
    }

    fun openDrawer() {
        drawerOpen.value = true
    }

    fun closeDrawer() {
        drawerOpen.value = false
    }
}