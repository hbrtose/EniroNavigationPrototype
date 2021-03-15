package com.eniro.nautical.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.eniro.nautical.BR
import com.eniro.nautical.util.viewModels
import kotlin.reflect.KClass

abstract class BaseFragment3<V : ViewDataBinding, T : BaseViewModel>(vm: KClass<T>, @LayoutRes private val layout: Int) : Fragment() {

    protected val viewModel: T by viewModels(vm)

    protected var binding: V? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        DataBindingUtil.inflate<V>(inflater, layout, container, false).let { binding ->
            binding.setVariable(BR.viewModel, viewModel)
            binding.lifecycleOwner = viewLifecycleOwner
            binding.root
        }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onBind(arguments)
    }

    protected open fun onBind(binding: V) {
        // no-op
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}