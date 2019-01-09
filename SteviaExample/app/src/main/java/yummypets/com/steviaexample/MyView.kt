package yummypets.com.steviaexample

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.widget.TextView
import com.octopepper.yummypets.common.stevia.*

class MyView(context: Context): ConstraintLayout(context) {

    val label = TextView(context)

    init {

        // View Hierarchy
        subviews(
            label
        )

        // Layout
        label.centerInParent()

        // Style
        label.style {
            textSize = 12F
        }

        // Content
        label.text = "Hello World"
    }
}