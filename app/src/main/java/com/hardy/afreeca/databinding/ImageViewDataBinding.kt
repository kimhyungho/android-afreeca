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
        "radius",
        "placeholder",
    ],
    requireAll = false
)
fun ImageView.bind(
    src: String?,
    isCircular: Boolean? = null,
    radius: Float = 0f,
    placeholder: Drawable? = null,
) {
    Glide.with(this)
        .load(src)
        .placeholder(placeholder)
        .error(placeholder)
        .apply {
            if (isCircular == true) {
                apply(RequestOptions.circleCropTransform())
            } else if (radius > 0) {
                transform(RoundedCorners(this@bind.context.dpToIntPx(radius)))
            }
        }.into(this)
}