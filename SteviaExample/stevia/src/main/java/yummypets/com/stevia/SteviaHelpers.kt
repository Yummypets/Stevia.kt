package com.octopepper.yummypets.common.stevia

import android.content.res.Resources
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
//import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

// Constants
val matchConstraint = ConstraintSet.MATCH_CONSTRAINT
val matchParent: Int = android.view.ViewGroup.LayoutParams.MATCH_PARENT
val wrapContent: Int = android.view.ViewGroup.LayoutParams.WRAP_CONTENT

// Style - Colors

fun View.color(resourceId: Int): Int {
    return ContextCompat.getColor(context, resourceId)
}

var TextView.textColor: Int
    get() = 0
    set(v) = setTextColor(v)

var Button.textColor: Int
    get() = 0
    set(v) = setTextColor(v)

var View.padding: Int
    get() = 0
    inline set(value) = setPadding(value, value, value, value)

var View.backgroundColor: Int
    get() = 0
    set(v) = setBackgroundColor(v)

// Style - Pixel densities

var Int.dp: Int
    get() {
        val metrics = Resources.getSystem().displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), metrics).toInt()
    }
    set(_) {}


var Float.dp: Float
    get() {
        val metrics = Resources.getSystem().displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, metrics)
    }
    set(_) {}


// Events

//fun View.onClick(context: CoroutineContext = Dispatchers.Main,
//                 handler: suspend CoroutineScope.(v: android.view.View?) -> Unit) {
//    setOnClickListener { v ->
//        GlobalScope.launch(context, CoroutineStart.DEFAULT) {
//            handler(v)
//        }
//    }
//}

// Layout - Helpers

fun ConstraintLayout.addConstraints(block: ConstraintSet.() -> Unit) {
    val cs = ConstraintSet()
    cs.clone(this)
    block(cs)
    cs.applyTo(this)
}
