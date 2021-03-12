package com.eniro.nautical.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import kotlin.reflect.KClass

abstract class BaseFragment<V: ViewBinding, T : BaseViewModel>(vm: KClass<T>): Fragment() {

    private var _binding: V? = null
    protected val binding get() = _binding!!
    val viewModel: T by viewModels(vm)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bind(inflater, container)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onBind(arguments)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected abstract fun bind(inflater: LayoutInflater, container: ViewGroup?): V
}