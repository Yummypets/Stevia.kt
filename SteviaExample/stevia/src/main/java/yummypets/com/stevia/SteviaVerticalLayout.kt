package yummypets.com.stevia

import android.view.View

// Vertical Layout

fun layout(vararg items: Any) {
    var previousMargin: Int? = null
    var previousView: View? = null
    var viewCount = 0
    for (item in items) {

        fun layoutView(view: View) {
            previousMargin?.let { previousMargin ->
                if (viewCount == 1) {
                    view.top(previousMargin)
                } else {
                    previousView?.let { previousView ->
                        view.constrainTopToBottomOf(previousView, previousMargin)
                    }
                }
            }
            previousView = view
        }

        // Embedded Horizontal layout.
        (item as? Array<Any>)?.let { horizontalLayout ->

            // Take first "View" type in the array to layout.
            var secondItem = if (horizontalLayout.count() > 1) horizontalLayout[1] else null
            var firstView = (horizontalLayout.firstOrNull() as? View)
                    ?: (secondItem as? View)
            firstView?.let {
                layoutView(it)
            }
        }

        when (item) {
            is Int -> {
                previousMargin = item
                if (viewCount == items.count() - 1) { // Last Margin == Bottom
                    previousView?.let { previousView ->
                        previousView.bottom(item)
                    }
                }
            }
            is View -> {
                layoutView(item)
            }
            is String -> {
                previousMargin = null
                previousView = null
            }
        }
        viewCount++
    }
}
