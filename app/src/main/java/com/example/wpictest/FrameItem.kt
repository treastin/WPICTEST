package com.example.wpictest

import android.graphics.drawable.Drawable

data class FrameItem(

    val frame: Drawable,
    val isPremium: Boolean,
    val is2ColumnWide: Boolean = false,
    var isAdWatched: Boolean = false
)
