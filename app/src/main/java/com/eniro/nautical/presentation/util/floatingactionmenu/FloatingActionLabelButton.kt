package com.eniro.nautical.presentation.util.floatingactionmenu

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.eniro.nautical.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FloatingActionLabelSideButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FloatingActionLabelButton(context, attrs, defStyleAttr) {

    override val layoutRes: Int
        get() = R.layout.floating_action_label_side_button
}

class FloatingActionLabelBelowButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : FloatingActionLabelButton(context, attrs, defStyleAttr) {

    override val layoutRes: Int
        get() = R.layout.floating_action_label_below_button
}

abstract class FloatingActionLabelButton @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

//    private var buttonColor: Int
//    private var textColor: Int
//    private var labelText: String
//    private var icon: Int
    private val textView: TextView
    private val button: FloatingActionButton

    abstract val layoutRes: Int

    init {
        inflate(context, layoutRes, this)
//        context.theme.obtainStyledAttributes(attrs, R.styleable.FloatingActionLabelButton, 0 ,0).apply {
//            try {
//                buttonColor = getResourceId(R.styleable.FloatingActionLabelButton_button_color, 0)
//                textColor = getResourceId(R.styleable.FloatingActionLabelButton_label_color, 0)
//                val textRes = getResourceId(R.styleable.FloatingActionLabelButton_label, 0)
//                labelText = context.getString(textRes)
//                icon = getResourceId(R.styleable.FloatingActionLabelButton_button_icon, 0)
//            } finally {
//                recycle()
//            }
//        }
        textView = findViewById(R.id.fab_label)
        button = findViewById(R.id.fab_item)
    }

    fun setOnClickListener(onClick: () -> Unit) {
        button.setOnClickListener { onClick() }
        invalidate()
    }

    fun setButtonBg(@ColorRes res: Int) {
        button.setBackgroundColor(resources.getColor(res))
        invalidate()
    }

    fun setButtonIcon(@DrawableRes res: Int) {
        button.setImageDrawable(ContextCompat.getDrawable(context, res))
        invalidate()
    }

    fun setLabelText(@StringRes res: Int) {
        textView.setText(res)
        invalidate()
    }

    fun setTextColor(@ColorRes res: Int) {
        textView.setTextColor(resources.getColor(res))
        invalidate()
    }
}