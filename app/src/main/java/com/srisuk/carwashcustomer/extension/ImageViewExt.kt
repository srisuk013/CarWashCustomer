package com.srisuk.carwashcustomer.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.srisuk.carwashcustomer.R

fun ImageView.setImageCircle(url: String?, @DrawableRes placeholder: Int = R.drawable.ic_user) {
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.placeholderOf(placeholder))
        .circleCrop()
        .into(this)
}
