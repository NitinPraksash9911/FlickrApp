package com.example.nitinflicker.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.nitinflicker.model.Photo


/**
 * Created by Nitin   on 2020-03-11.
 */
class BindingAdapters {

    companion object {
        @BindingAdapter("loadImage")
        @JvmStatic
        fun loadImage(view: ImageView, photo: Photo) {
            val imageUrl =
                "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_n.jpg"
            Glide.with(view.getContext())
                .load(imageUrl)
                .into(view)
        }


    }
}