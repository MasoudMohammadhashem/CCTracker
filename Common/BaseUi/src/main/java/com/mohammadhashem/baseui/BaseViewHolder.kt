package com.mohammadhashem.baseui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.mohammadhashem.utils.imageloader.GlideImageLoader

abstract class BaseViewHolder<T>(open val  binding: ViewBinding,open val context: Context) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(task: T, imageLoader: GlideImageLoader, position: Int)
}
