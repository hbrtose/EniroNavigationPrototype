package com.eniro.nautical.presentation.scene.product

import com.eniro.nautical.R
import com.eniro.nautical.databinding.FragmentProductsBinding
import com.eniro.nautical.presentation.base.BaseFragment3
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment3<FragmentProductsBinding, ProductsViewModel>(ProductsViewModel::class, R.layout.fragment_products)