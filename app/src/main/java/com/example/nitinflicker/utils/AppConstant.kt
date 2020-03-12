package com.example.nitinflicker.utils

object AppConstant {
    const val SMALL = "n"

    const val PAGE_ITEM= 40
    const val FIRST_PAGE = 1
    const val TAG = "searchTag"

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