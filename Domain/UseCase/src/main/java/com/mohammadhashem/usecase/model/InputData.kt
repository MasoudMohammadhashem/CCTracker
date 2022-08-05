package com.mohammadhashem.usecase.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InputData (
    val start:Int,
    val limit: Int,
    val sort: String,
    val sort_type: String,
    val volume24_min: Double,
    val volume24_max: Double,
    val percent_change24_min: Double,
    val percent_change24_max: Double,
):Parcelable