package com.jihyun.kreamclone

import androidx.annotation.DrawableRes

data class womenItem(
    val itemType: Int,
    @DrawableRes val image: Int?,
    val title: String?,
    val subTitle: String?,
    val brand: String?,
    val price: String?
)
