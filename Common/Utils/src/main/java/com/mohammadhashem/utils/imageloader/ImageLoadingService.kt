package com.mohammadhashem.utils.imageloader

import android.widget.ImageView


interface ImageLoadingService {
    fun loadImage(imageView: ImageView, imageUrl: String?)
}
