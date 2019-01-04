package com.octopepper.yummypets.common.stevia
import android.content.Context
import android.view.View

fun steviaTests(context: Context) {
    val label = View(context)
    val button = View(context)
    val textView = View(context)
    val test1: View = I-label
    val test2: View = I-10-label
    val test3: View = label-I
    val test4: View = label-20-I
    val test5: Array<View> = label-20-button
    val test6: Array<View> = I-label-20-button
    val test7: Array<View> = I-42-label-20-button
    val test8: Array<View> = label-20-button-I
    val test9: Array<View> = label-20-button-42-I
    val test10: Array<View> = label-20-button-42-textView-20-I
}