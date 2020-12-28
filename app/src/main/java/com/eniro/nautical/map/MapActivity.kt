package com.eniro.nautical.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.eniro.nautical.R
import com.eniro.nautical.databinding.ActivityMapBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MapActivity : AppCompatActivity() {

    private lateinit var navMenuController: NavController
    private lateinit var navOverlayController: NavController
    private lateinit var binding: ActivityMapBinding
    private val navCoordinatorViewModel: NavCoordinatorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navMenuController = (supportFragmentManager.findFragmentById(R.id.nav_host_menu) as NavHostFragment).navController
        navOverlayController = (supportFragmentManager.findFragmentById(R.id.nav_host_overlay) as NavHostFragment).navController
        navCoordinatorViewModel.navigateToOverlay.observe(this, Observer { navigateToOverlay(it) })
        navCoordinatorViewModel.drawerOpen.observe(this, Observer { toggleDrawer(it) })
    }

    private fun toggleDrawer(open: Boolean) {
        if (open) {
            (binding.mainSlidingView as DrawerLayout).openDrawer(binding.navHostMenu, true)
        } else {
            (binding.mainSlidingView as DrawerLayout).closeDrawer(binding.navHostMenu, true)
        }
    }

    private fun navigateToOverlay(actionId: Int) {
        if (actionId == NavCoordinatorViewModel.POP_BACKSTACK) {
            navOverlayController.popBackStack()
            return
        }
        navOverlayController.navigate(actionId)
    }
}