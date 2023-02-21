package com.jihyun.kreamclone

import androidx.annotation.DrawableRes

data class ProductItem(
    val productType: Int,
    @DrawableRes val image: Int,
    val brand: String,
    val name: String,
    val price: String,
    val sale: String?,
    val option: Int
)
