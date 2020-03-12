package com.example.nitinflicker.utils

object AppConstant {
    const val NETWORK_TIMEOUT: Long = 30
    const val SMALL = "n"
    const val MEDIUM = "-"

    const val PAGE_ITEM= 20
    const val FIRST_PAGE = 1
    const val TAG = "Cat"

    fun getImageUrl(
        id: String,
        secret: String,
        serverId: String,
        farmId: Int,
        size: String
    ): String {
        return "https://farm$farmId.staticflickr.com/$serverId/${id}_${secret}_$size.jpg"
    }
}