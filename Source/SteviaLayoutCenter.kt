package com.octopepper.yummypets.common.stevia

import android.support.constraint.ConstraintLayout
import android.view.View

// Layout - Center

fun <T : View> T.centerInParent(): T {
    return centerHorizontally().centerVertically()
}

fun <T : View> T.centerHorizontally(): T {
    (parent as? ConstraintLayout)?.let { constraintLayout ->
        constraintLayout.addConstraints {
            centerHorizontally(id, constraintLayout.id)
        }
    }
    return this
}

fun <T : View> T.centerVertically(): T {
    (parent as? ConstraintLayout)?.let { constraintLayout ->
        constraintLayout.addConstraints {
            centerVertically(id, constraintLayout.id)
        }
    }
    return this
}
