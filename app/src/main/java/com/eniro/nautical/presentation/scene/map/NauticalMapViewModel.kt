package com.eniro.nautical.presentation.scene.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eniro.nautical.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NauticalMapViewModel @Inject constructor() : BaseViewModel() {

    private val _fabExpanded = MutableLiveData<Boolean>()
    val fabExpanded: LiveData<Boolean> = _fabExpanded

    init {
        _fabExpanded.value = false
    }

    fun toggleFab() {
        _fabExpanded.value = _fabExpanded.value?.not()
    }
}