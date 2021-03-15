package com.eniro.nautical.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.eniro.nautical.BR
import com.eniro.nautical.util.viewModels
import kotlin.reflect.KClass

abstract class BaseFragment2<V : ViewBinding, T : BaseViewModel>(
    vm: KClass<T>,
    private val binder: (View) -> V,
    @LayoutRes private val layout: Int
) : Fragment() {

    val viewModel: T by viewModels(vm)

    protected var binding: V? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(layout, container, false)

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        viewModel.onBind(arguments)
    }

    private fun bind(view: View) = binder.invoke(view).also { binding ->
        (binding as? ViewDataBinding)?.apply {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = viewLifecycleOwner
        }
        this.binding = binding
        onBind(binding)
    }

    protected open fun onBind(binding: V) {
        // no-op
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}