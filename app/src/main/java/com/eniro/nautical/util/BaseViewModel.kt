package com.eniro.nautical.util

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    val error = SingleLiveEvent<String>()

}