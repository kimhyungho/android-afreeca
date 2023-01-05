package com.hardy.afreeca.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

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
    radius: Int = 0,
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
                transform(RoundedCorners(radius))
            }
        }.into(this)
}