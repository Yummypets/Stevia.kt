package yummypets.com.stevia

import android.view.View

enum class Anchor {
    LEFT,
    RIGHT,
    TOP,
    BOTTOM,
    CENTERX,
    CENTERY
//    BASELINE(ConstraintLayout.LayoutParams.BASELINE),
//    START(ConstraintLayout.LayoutParams.START),
//    END(ConstraintLayout.LayoutParams.END)
}

fun alignLefts(vararg views: View) = align(Anchor.LEFT, views)
fun alignRights(vararg views: View) = align(Anchor.RIGHT, views)
fun alignTops(vararg views: View) = align(Anchor.TOP, views)
fun alignBottoms(vararg views: View) = align(Anchor.BOTTOM, views)
fun alignHorizontally(vararg views: View) = align(Anchor.CENTERY, views)
fun alignVertically(vararg views: View) = align(Anchor.CENTERX, views)

private fun align(edge: Anchor, views: Array<out View>){
    var firstView: View? = null
    views.forEachIndexed { index, view ->
        if (index == 0) {
            firstView = view
        } else {
            when(edge) {
                Anchor.LEFT -> view.constrainLeftToLeftOf(firstView!!)
                Anchor.RIGHT -> view.constrainRightToRightOf(firstView!!)
                Anchor.TOP -> view.constrainTopToTopOf(firstView!!)
                Anchor.BOTTOM -> view.constrainBottomToBottomOf(firstView!!)
                Anchor.CENTERX -> view.constrainCenterXToCenterXOf(firstView!!)
                Anchor.CENTERY -> view.constrainCenterYToCenterYOf(firstView!!)
            }
        }
    }
}



