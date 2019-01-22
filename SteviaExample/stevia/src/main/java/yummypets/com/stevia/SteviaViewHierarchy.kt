package yummypets.com.stevia

import android.view.View
import android.view.ViewGroup

// View Hierarchy

fun ViewGroup.subviews(vararg views: View): View {
    assignViewIdIfNeeded()
    for (v in views) {
        v.assignViewIdIfNeeded()
        addView(v)
    }
    return this
}

fun View.assignViewIdIfNeeded() {
    if (id == -1) {
        id = View.generateViewId()
    }
}