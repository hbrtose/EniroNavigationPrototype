package com.eniro.nautical.presentation.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.eniro.nautical.util.viewModels
import kotlin.reflect.KClass

abstract class BaseFragment<T : BaseViewModel>(vm: KClass<T>): Fragment() {

    protected val viewModel: T by viewModels(vm)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onBind(arguments)
    }
}