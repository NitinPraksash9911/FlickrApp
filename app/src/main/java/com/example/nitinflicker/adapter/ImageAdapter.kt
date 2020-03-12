package com.example.nitinflicker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nitinflicker.databinding.ListItemViewBinding
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.utils.AppConstant


/**
 * Created by  Nitin on 2020-03-11.
 */
class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    private var imageList = arrayListOf<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {

        val binding =
            ListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return imageList.size

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.bind(imageList.get(position))

    }

    /*set list data*/
    fun setListData(photoList: ArrayList<Photo>) {
        this.imageList = photoList
        notifyDataSetChanged()
    }


    class ImageViewHolder(private var binding: ListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo?) {
            if (photo?.id != null) {
                binding.imageUrl = AppConstant.getImageUrl(
                    photo.id,
                    photo.secret,
                    photo.server,
                    photo.farm,
                    AppConstant.SMALL
                )

            }
        }
    }
}