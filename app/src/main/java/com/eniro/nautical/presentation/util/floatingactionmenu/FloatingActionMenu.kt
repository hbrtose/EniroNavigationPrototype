package com.eniro.nautical.presentation.util.floatingactionmenu

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.transition.TransitionManager
import com.eniro.nautical.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FloatingActionMenu @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val verticalItems = mutableListOf<FloatingActionLabelSideButton>()
    private val horizontalItems = mutableListOf<FloatingActionLabelBelowButton>()
    private val main: FloatingActionButton
    private val parentView: ConstraintLayout

    init {
        inflate(context, R.layout.floating_action_menu, this)
        main = findViewById(R.id.fab_toggle)
        parentView = findViewById(R.id.floating_menu_parent)
    }

    fun getButton() : FloatingActionButton {
        return main
    }

    fun toggle(show: Boolean) {
        if (show) {
            expand()
        } else {
            hide()
        }
    }

    private fun expand(){
        val constraintSet = ConstraintSet()
        constraintSet.clone(parentView)
        for ((index, item) in verticalItems.withIndex()) {
            if (index == 0) {
                constraintSet.addConstraintsForVertical(item.id, R.id.fab_toggle)
            } else {
                constraintSet.addConstraintsForVertical(item.id, verticalItems[index-1].id)
            }
        }
        for ((index, item) in horizontalItems.withIndex()) {
            if (index == 0) {
                constraintSet.addConstraintsForHorizontal(item.id, R.id.fab_toggle)
            } else {
                constraintSet.addConstraintsForHorizontal(item.id, horizontalItems[index-1].id)
            }
        }
        constraintSet.applyTo(this)
        TransitionManager.beginDelayedTransition(this)
    }

    private fun hide() {
        val constraintSet = ConstraintSet()
        constraintSet.clone(parentView)
        for (item in verticalItems) {
            constraintSet.addConstraintsForHide(item.id)
        }
        for (item in horizontalItems) {
            constraintSet.addConstraintsForHide(item.id)
        }
        constraintSet.applyTo(this)
        TransitionManager.beginDelayedTransition(this)
    }

    fun addVerticalItems(items: List<FloatingActionMenuItem>) {
        verticalItems.addAll(items.map {
            FloatingActionLabelSideButton((context)).apply {
                createItem(this, it)
            }
        })
    }

    fun addHorizontalItems(items: List<FloatingActionMenuItem>) {
        horizontalItems.addAll(items.map {
            FloatingActionLabelBelowButton((context)).apply {
                createItem(this, it)
            }
        })
    }

    private fun createItem(item: FloatingActionLabelButton, data: FloatingActionMenuItem) {
        item.apply {
            setOnClickListener { data.onClick }
            setButtonIcon(data.icon)
            setLabelText(data.label)
            id = generateViewId()
            val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            layoutParams = params
            parentView.addView(this)
            val constraintSet = ConstraintSet()
            constraintSet.clone(parentView)
            constraintSet.addConstraintsForHide(id)
            constraintSet.applyTo(this)
        }
    }

    private fun ConstraintSet.addConstraintsForVertical(currentId: Int, previousId:Int) {
        connect(currentId, ConstraintSet.BOTTOM, previousId, ConstraintSet.TOP)
        connect(currentId, ConstraintSet.END, R.id.fab_toggle, ConstraintSet.END)
    }

    private fun ConstraintSet.addConstraintsForHorizontal(currentId: Int, previousId:Int) {
        connect(currentId, ConstraintSet.TOP, R.id.fab_toggle, ConstraintSet.TOP)
        connect(currentId, ConstraintSet.END, previousId, ConstraintSet.START)
    }

    private fun ConstraintSet.addConstraintsForHide(currentId: Int) {
        connect(currentId, ConstraintSet.TOP, R.id.fab_toggle, ConstraintSet.TOP)
        connect(currentId, ConstraintSet.END, R.id.fab_toggle, ConstraintSet.END)
    }

    private fun ConstraintSet.constrainMainToParent() {

    }
}