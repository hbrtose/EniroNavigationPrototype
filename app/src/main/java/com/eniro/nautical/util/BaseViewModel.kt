package com.eniro.nautical.util

import android.os.Bundle
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {

    val error = SingleLiveEvent<String>()
    private val disposables = CompositeDisposable()

    open fun onBind(arguments: Bundle?) {
        // no-op
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    protected fun Disposable.register() {
        disposables.add(this)
    }
}