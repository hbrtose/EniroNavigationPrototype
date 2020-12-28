package com.eniro.nautical.product

import android.view.LayoutInflater
import android.view.ViewGroup
import com.eniro.nautical.databinding.FragmentProductsBinding
import com.eniro.nautical.util.BaseFragment

class ProductsFragment: BaseFragment<FragmentProductsBinding>() {
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentProductsBinding {
        return FragmentProductsBinding.inflate(inflater, container, false)
    }
}