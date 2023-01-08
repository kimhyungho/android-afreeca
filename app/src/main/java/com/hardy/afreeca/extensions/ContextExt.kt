package com.hardy.afreeca.extensions

import android.content.Context
import android.util.TypedValue
import kotlin.math.roundToInt

fun Context.dpToIntPx(dp: Float): Int {
    val displayMetrics = this.resources.displayMetrics
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics).roundToInt()
}