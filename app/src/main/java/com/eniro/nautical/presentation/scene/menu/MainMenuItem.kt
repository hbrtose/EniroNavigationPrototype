package com.eniro.nautical.presentation.scene.menu

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainMenuItem(
    @DrawableRes val icon: Int,
    @StringRes val name: Int,
    val onClick: () -> Unit
)