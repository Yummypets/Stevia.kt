package com.octopepper.yummypets.common.stevia

import android.support.constraint.ConstraintSet
import android.view.View

// Layout - Fill

fun <T : View> T.fillParent(padding: Int = 0): T {
    return fillVertically(padding).fillHorizontally(padding)
}

fun <T : View> T.fillVertically(padding: Int = 0): T {
    layoutParams.height = ConstraintSet.MATCH_CONSTRAINT // Needed to "match constraints"
    return top(padding).bottom(padding)
}

fun <T : View> T.fillHorizontally(padding: Int = 0): T {
    layoutParams.width = ConstraintSet.MATCH_CONSTRAINT // Needed to "match constraints"
    return left(padding).right(padding)
}