package yummypets.com.stevia

import android.view.View

// Style

inline fun <T : View> T.style(block: T.() -> Unit): T {
    return this.apply(block)
}
