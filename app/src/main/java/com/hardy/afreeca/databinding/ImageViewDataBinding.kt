package com.hardy.afreeca.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.hardy.afreeca.extensions.dpToIntPx

@BindingAdapter(
    value = [
        "src",
        "isCircular",
        "placeholder",
        "overrideWidth",
        "overrideHeight"
    ],
    requireAll = false
)
fun ImageView.bind(
    src: String?,
    isCircular: Boolean? = null,
    placeholder: Drawable? = null,
    overrideWidth: Float? = null,
    overrideHeight: Float? = null
) {
    fun dpToIntPx(dp: Float): Int {
        return this@bind.context.dpToIntPx(dp)
    }

    Glide.with(this)
        .load(src)
        .placeholder(placeholder)
        .error(placeholder)
        .apply {
            if (overrideWidth != null && overrideHeight != null) {
                override(
                    dpToIntPx(overrideWidth),
                    dpToIntPx(overrideHeight)
                )
            }
            if (isCircular == true) {
                apply(RequestOptions.circleCropTransform())
            }
        }.into(this)
}