package com.eniro.nautical.menu

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainMenuItem(
    @DrawableRes val icon: Int,
    @StringRes val name: Int,
    val onClick: () -> Unit,
    val onSwitch: ((Boolean) -> Unit)?
)