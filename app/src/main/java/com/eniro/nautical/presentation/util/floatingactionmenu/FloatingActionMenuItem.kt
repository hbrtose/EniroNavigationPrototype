package com.eniro.nautical.presentation.util.floatingactionmenu

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class FloatingActionMenuItem(@DrawableRes val icon: Int, @StringRes val label: Int, val onClick: () -> Unit)