package com.jihyun.kreamclone

import androidx.annotation.DrawableRes

data class HomeItem(
    val itemType: Int,
    @DrawableRes val image: List<Int?>,
    val title: List<String?>,
    val subTitle: String?,
    val product: List<ProductItem?>
)
