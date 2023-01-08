package com.hardy.afreeca.databinding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleOrGone")
fun View.bindVisibleOrGone(isVisible: Boolean?) {
    this.visibility = if (isVisible == true) View.VISIBLE else View.GONE
}