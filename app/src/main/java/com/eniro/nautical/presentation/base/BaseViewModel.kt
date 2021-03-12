package com.eniro.nautical.presentation.base

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eniro.nautical.util.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel: ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    private val disposables = CompositeDisposable()
    val error = SingleLiveEvent<String>()
    val loading: LiveData<Boolean> = _loading

    open fun onBind(arguments: Bundle?) {
        // no-op
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    protected fun Disposable.register() {
        disposables.add(this)
        _loading.value = true
    }
}