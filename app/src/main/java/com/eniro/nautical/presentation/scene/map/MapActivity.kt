package com.eniro.nautical.presentation.scene.map

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.eniro.nautical.R
import com.eniro.nautical.databinding.ActivityMapBinding
import dagger.hilt.android.AndroidEntryPoint

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
        navCoordinatorViewModel.navigateToOverlay.observe(this, { navigateToOverlay(it) })
        navCoordinatorViewModel.drawerOpen.observe(this, { toggleDrawer(it) })
    }

    private fun toggleDrawer(open: Boolean) {
        if (open) {
            (binding.mainSlidingView as DrawerLayout).openDrawer(binding.navHostMenu, true)
        } else {
            (binding.mainSlidingView as DrawerLayout).closeDrawer(binding.navHostMenu, true)
        }
    }

    private fun navigateToOverlay(actionId: Int) {
        if (actionId == NavCoordinatorViewModel.NAVIGATE_TO_HOME) {
            navOverlayController.navigateUp()
            return
        }
        navOverlayController.navigate(actionId)
    }
}