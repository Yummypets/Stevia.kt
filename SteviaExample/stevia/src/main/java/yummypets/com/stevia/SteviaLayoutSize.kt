package yummypets.com.stevia

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.view.View
import android.view.ViewGroup

// Layout - Size

fun <T : View> T.size(value: Int): T {
    return width(value).height(value)
}

fun <T : View> T.width(value: Int): T {
    return width(value.toFloat())
}

fun <T : View> T.height(value: Int): T {
    return height(value.toFloat())
}

fun <T : View> T.width(value: Float): T {

    if (value.toInt() == ConstraintSet.MATCH_CONSTRAINT) {
        layoutParams.width = value.toInt()
        return this
    }

    if (parent is ConstraintLayout) {
        (parent as? ConstraintLayout)?.let { constraintLayout ->
            constraintLayout.addConstraints {
                constrainWidth(id, value.dp.toInt())
            }
        }
    } else {
        if (layoutParams == null) {
            layoutParams = ViewGroup.LayoutParams(ConstraintSet.WRAP_CONTENT, ConstraintSet.WRAP_CONTENT)
        }

        if (layoutParams != null) {
            layoutParams.width = if (value > 0) value.dp.toInt() else value.toInt()
        } else {

            print("NULL")
        }
    }
    return this
}

fun <T : View> T.height(value: Float): T {

    if (value.toInt() == ConstraintSet.MATCH_CONSTRAINT) {
        layoutParams.height = value.toInt()
        return this
    }

    if (parent is ConstraintLayout) {
        (parent as? ConstraintLayout)?.let { constraintLayout ->
            constraintLayout.addConstraints {
                constrainHeight(id, value.dp.toInt())
            }
        }
    } else {

        if (layoutParams == null) {
            layoutParams = ViewGroup.LayoutParams(ConstraintSet.WRAP_CONTENT, ConstraintSet.WRAP_CONTENT)
        }

        if (layoutParams != null) {
            layoutParams.height = if (value > 0) value.dp.toInt() else value.toInt()
        }
    }
    return this
}


// Percent Size

fun <T : View> T.percentWidth(value: Float): T {
    layoutParams.width = ConstraintSet.MATCH_CONSTRAINT
    (parent as? ConstraintLayout)?.let { constraintLayout ->
        constraintLayout.addConstraints {
            constrainPercentWidth(id, value)
        }
    }
    return this
}

fun <T : View> T.percentHeight(value: Float): T {
    layoutParams.height = ConstraintSet.MATCH_CONSTRAINT
    (parent as? ConstraintLayout)?.let { constraintLayout ->
        constraintLayout.addConstraints {
            constrainPercentHeight(id, value)
        }
    }
    return this
}

