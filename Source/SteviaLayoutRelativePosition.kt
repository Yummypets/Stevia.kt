package com.octopepper.yummypets.common.stevia

import android.support.constraint.ConstraintLayout
import android.view.View

// Layout - Relative Position

fun <T : View> T.constrainTopToBottomOf(view: View, margin: Int = 0): T {
    return constrainTopToBottomOf(view.id, margin)
}

fun <T : View> T.constrainTopToBottomOf(viewId: Int, margin: Int = 0): T {
    (parent as? ConstraintLayout)?.addConstraints {
        connect(id, ConstraintLayout.LayoutParams.TOP, viewId, ConstraintLayout.LayoutParams.BOTTOM, margin.dp)
    }
    return this
}

fun <T : View> T.constrainLeftToRightOf(view: View, margin: Int = 0): T {
    return constrainLeftToRightOf(view.id, margin)
}

fun <T : View> T.constrainLeftToRightOf(viewId: Int, margin: Int = 0): T {
    (parent as? ConstraintLayout)?.addConstraints {
        connect(id, ConstraintLayout.LayoutParams.LEFT, viewId, ConstraintLayout.LayoutParams.RIGHT, margin.dp)
    }

    return this
}

fun <T : View> T.constrainRightToLeftOf(view: View, margin: Int = 0): T {
    return constrainRightToLeftOf(view.id, margin)
}

fun <T : View> T.constrainRightToLeftOf(viewId: Int, margin: Int = 0): T {
    (parent as? ConstraintLayout)?.addConstraints {
        connect(id, ConstraintLayout.LayoutParams.RIGHT, viewId, ConstraintLayout.LayoutParams.LEFT, margin.dp)
    }

    return this
}

fun <T : View> T.constrainBottomToTopOf(view: View, margin: Int = 0): T {
    return constrainBottomToTopOf(view.id, margin)
}

fun <T : View> T.constrainBottomToTopOf(viewId: Int, margin: Int = 0): T {
    (parent as? ConstraintLayout)?.addConstraints {
        connect(id, ConstraintLayout.LayoutParams.BOTTOM, viewId, ConstraintLayout.LayoutParams.TOP, margin.dp)
    }
    return this
}

fun <T : View> T.constrainBottomToBottomOf(view: View, margin: Int = 0): T {
    return constrainBottomToBottomOf(view.id, margin)
}

fun <T : View> T.constrainBottomToBottomOf(viewId: Int, margin: Int = 0): T {
    (parent as? ConstraintLayout)?.addConstraints {
        connect(id, ConstraintLayout.LayoutParams.BOTTOM, viewId, ConstraintLayout.LayoutParams.BOTTOM, margin.dp)
    }
    return this
}

