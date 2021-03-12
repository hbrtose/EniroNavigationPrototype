package com.eniro.nautical.presentation.scene.product

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentProductsBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment: BaseViewBindingFragment<FragmentProductsBinding, ProductsViewModel>(ProductsViewModel::class) {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentProductsBinding {
        return FragmentProductsBinding.inflate(inflater, container, false)
    }
}