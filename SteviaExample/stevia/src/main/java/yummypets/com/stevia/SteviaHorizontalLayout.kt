package yummypets.com.stevia

import android.view.View


/// Represents a side of the parent view.
object I

class SinglePartialConstraint(val view: View, val margin: Int)

class MultiplePartialConstraint(val views: Array<View>, val margin: Int)

class SideConstraint(val constant: Int)


// I-view
operator fun I.minus(view: View): View {
    view.left(0)
    return view
}

// I-42
operator fun I.minus(margin: Int): SideConstraint {
    return SideConstraint(margin)
}

// (I-42)-view
operator fun SideConstraint.minus(view: View): View {
    view.left(constant)
    return view
}

// view-I
operator fun View.minus(side: I): View {
    this.right(0)
    return this
}

// (view-42)-I
operator fun SinglePartialConstraint.minus(side: I): View {
    view.right(margin)
    return view
}

// viewA-viewB
operator fun View.minus(view: View): Array<View> {
    // Somehow these don't have the same effect.
    // (not reflexive)
//    view.constrainLeftToRightOf(this)
    this.constrainRightToLeftOf(view)
    return arrayOf(this, view)
}

// view-42
operator fun View.minus(margin: Int): SinglePartialConstraint {
    return SinglePartialConstraint(this, margin)
}

// (previousView-42)-view
operator fun SinglePartialConstraint.minus(right: View): Array<View> {
    right.constrainLeftToRightOf(view, margin)
    return arrayOf(view, right)
}

// (viewA-viewB)-I
operator fun Array<View>.minus(side: I): Array<View> {
    lastOrNull()?.right(0)
    return this
}

// (viewA-viewB)-42
operator fun Array<View>.minus(margin: Int): MultiplePartialConstraint {
    return MultiplePartialConstraint(this, margin)
}

// (viewA-viewB)-(42-I)
operator fun MultiplePartialConstraint.minus(side: I): Array<View> {
    views.last().right(margin)
    return views
}

// (viewA-viewB-42)-view
operator fun MultiplePartialConstraint.minus(view: View): Array<View> {
    view.constrainLeftToRightOf(views.last(), margin)
    return views + view
}

fun horizontalLayout(vararg items: Any): Array<out Any> {
    var previousMargin: Int? = null
    var previousView: View? = null
    var viewCount = 0
    for (item in items) {

        when (item) {
            is Int -> {
                previousMargin = item
                if (viewCount == items.count() - 1) { // Last Margin == Bottom
                    previousView?.let { previousView ->
                        previousView.right(item)
                    }
                }
            }
            is View -> {
                previousMargin?.let { previousMargin ->
                    if (viewCount == 1) {
                        item.left(previousMargin)
                    } else {
                        previousView?.let { previousView ->

                            item.constrainLeftToRightOf(previousView, previousMargin)
//                            item.constrainRightToLeftOf(previousView, previousMargin)
                        }
                    }
                }
                previousView = item
            }
            is String -> {
                previousMargin = null
                previousView = null
            }
        }
        viewCount++
    }
    return items
}