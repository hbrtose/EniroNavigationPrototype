package com.eniro.nautical.presentation.util

import android.view.View

fun View.visible(visible: Boolean) {
    visibility = if (visible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}