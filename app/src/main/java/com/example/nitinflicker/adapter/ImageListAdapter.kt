package com.example.nitinflicker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nitinflicker.databinding.ListItemViewBinding
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.utils.AppConstant


/**
 * Created by Nitin  on 2020-03-12.
 */
class ImageListAdapter : PagedListAdapter<Photo, ImageListAdapter.ImageViewHolder>(UserDiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.bind(getItem(position))
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


    companion object {
        private val UserDiffCallback: DiffUtil.ItemCallback<Photo?> =
            object : DiffUtil.ItemCallback<Photo?>() {
                override fun areItemsTheSame(@NonNull oldItem: Photo, @NonNull newItem: Photo) =
                    oldItem.getId() === newItem.getId()

                override fun areContentsTheSame(oldItem: Photo, newItem: Photo) =
                    oldItem.equals(newItem)


            }
    }
}