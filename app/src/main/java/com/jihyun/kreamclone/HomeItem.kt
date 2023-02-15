package com.jihyun.kreamclone

import androidx.annotation.DrawableRes

data class HomeItem(
    val itemType: Int,
    @DrawableRes val image: List<Int?>,
    val title: List<String?>,
    val subTitle: List<String?>,
    val price: List<String?>,
    val quickDelivery: List<Int?>
)
