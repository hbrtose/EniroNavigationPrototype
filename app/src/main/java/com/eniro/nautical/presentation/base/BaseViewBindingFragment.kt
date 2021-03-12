package com.eniro.nautical.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseViewBindingFragment<V: ViewBinding, T : BaseViewModel>(vm: KClass<T>): BaseFragment<T>(vm) {

    private var _binding: V? = null
    protected val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bind(inflater, container)
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun bind(inflater: LayoutInflater, container: ViewGroup?): V
}