package com.eniro.nautical.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.eniro.nautical.R
import com.eniro.nautical.databinding.FragmentMenuMainBinding
import com.eniro.nautical.map.NavCoordinatorViewModel
import com.eniro.nautical.util.BaseFragment

class MainMenuFragment: BaseFragment<FragmentMenuMainBinding>() {

    private val adapter by lazy { MainMenuAdapter(getMainMenu()) }
    private val navCoordinatorViewModel: NavCoordinatorViewModel by activityViewModels()

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentMenuMainBinding {
        return FragmentMenuMainBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.menuItems.layoutManager = LinearLayoutManager(requireContext())
        binding.menuItems.adapter = adapter
    }

    private fun getMainMenu(): List<MainMenuItem> {
        return listOf(
            MainMenuItem(
                R.mipmap.ic_launcher,
                R.string.products,
                { findNavController().navigate(R.id.action_mainMenuFragment_to_productsFragment) },
                null
             ),
            MainMenuItem(
                R.mipmap.ic_launcher,
                R.string.pois,
                { findNavController().navigate(R.id.action_mainMenuFragment_to_POIListFragment) },
                {
                    if (it) {
                        navCoordinatorViewModel.removeOverlays()
                        navCoordinatorViewModel.showPois()
                    } else {
                        navCoordinatorViewModel.hidePois()
                    }
                }
            ),
            MainMenuItem(
                R.mipmap.ic_launcher,
                R.string.search,
                {
                    navCoordinatorViewModel.closeDrawer()
                    navCoordinatorViewModel.removeOverlays()
                    navCoordinatorViewModel.navigateToOverlay(R.id.action_nauticalMapFragment_to_geoSearchOverlayFragment)
                },
                null
            )
        )
    }
}