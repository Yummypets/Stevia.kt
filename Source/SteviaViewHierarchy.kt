package com.octopepper.yummypets.common.stevia

import android.view.View
import android.view.ViewGroup

// View Hierarchy

fun ViewGroup.subviews(vararg views: View): View {
    if (id == -1) {
        id = View.generateViewId()
    }
    for (v in views) {
        v.id = View.generateViewId()
        addView(v)
    }
    return this
}