package com.eniro.nautical.util

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlin.reflect.KClass

@MainThread
fun <VM : ViewModel> Fragment.viewModels(
    vm: KClass<VM>,
    ownerProducer: () -> ViewModelStoreOwner = { this },
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
) = createViewModelLazy(
    viewModelClass = vm,
    storeProducer = { ownerProducer().viewModelStore },
    factoryProducer = factoryProducer
)

@MainThread
fun <VM : ViewModel> Fragment.activityViewModels(
    vm: KClass<VM>,
    factoryProducer: (() -> ViewModelProvider.Factory)? = null
) = createViewModelLazy(
    viewModelClass = vm,
    storeProducer = { requireActivity().viewModelStore },
    factoryProducer = factoryProducer ?: { requireActivity().defaultViewModelProviderFactory }
)