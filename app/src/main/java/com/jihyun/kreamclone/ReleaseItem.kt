package com.jihyun.kreamclone

import androidx.annotation.DrawableRes

data class ReleaseItem(
    @DrawableRes val image: Int,
    val brand: String,
    val name: String,
    val option: Int
)
