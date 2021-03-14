package com.eniro.nautical.presentation.scene.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.eniro.nautical.R
import com.eniro.nautical.databinding.FragmentNauticalMapBinding
import com.eniro.nautical.presentation.base.BaseViewBindingFragment
import com.eniro.nautical.presentation.util.floatingactionmenu.FloatingActionMenuItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NauticalMapFragment: BaseViewBindingFragment<FragmentNauticalMapBinding, NauticalMapViewModel>(NauticalMapViewModel::class) {

    private val navCoordinatorViewModel: NavCoordinatorViewModel by activityViewModels()
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentNauticalMapBinding {
        return FragmentNauticalMapBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabMain.addVerticalItems(listOf(
            FloatingActionMenuItem(R.drawable.ic_launcher_foreground, R.string.app_name) { Toast.makeText(context, "poi", Toast.LENGTH_LONG).show() },
            FloatingActionMenuItem(R.drawable.ic_launcher_foreground, R.string.app_name) { Toast.makeText(context, "ais", Toast.LENGTH_LONG).show() },
            FloatingActionMenuItem(R.drawable.ic_launcher_foreground, R.string.app_name) { Toast.makeText(context, "harbor", Toast.LENGTH_LONG).show() }
        ))
        binding.fabMain.addHorizontalItems(listOf(
            FloatingActionMenuItem(R.drawable.ic_launcher_foreground, R.string.app_name) { Toast.makeText(context, "nautical", Toast.LENGTH_LONG).show() },
            FloatingActionMenuItem(R.drawable.ic_launcher_foreground, R.string.app_name) { Toast.makeText(context, "aerial", Toast.LENGTH_LONG).show() },
            FloatingActionMenuItem(R.drawable.ic_launcher_foreground, R.string.app_name) { Toast.makeText(context, "hybrid", Toast.LENGTH_LONG).show() }
        ))
        binding.drawerOpener.setOnClickListener { navCoordinatorViewModel.openDrawer() }
        binding.fabMain.getButton().setOnClickListener { viewModel.toggleFab() }
        viewModel.fabExpanded.observe(viewLifecycleOwner, { toggleFab(it) })
    }

    private fun toggleFab(open: Boolean) {
        binding.fabMain.toggle(open)
    }
}