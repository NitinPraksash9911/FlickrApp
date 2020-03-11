package com.example.nitinflicker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nitinflicker.BuildConfig
import com.example.nitinflicker.R
import com.example.nitinflicker.adapter.ImageAdapter
import com.example.nitinflicker.databinding.ActivityResultScreenBinding
import com.example.nitinflicker.viewmodel.ImageLoadViewModel

class ResultScreen : AppCompatActivity() {

    lateinit var imageLoadViewModel: ImageLoadViewModel
    lateinit var imageAdapter: ImageAdapter
    lateinit var resultScreenBinding: ActivityResultScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_result_screen)

        //initialization
        init()
    }


    private fun init() {
        resultScreenBinding.lifecycleOwner = this
        imageLoadViewModel = ViewModelProvider(this).get(ImageLoadViewModel::class.java)
        resultScreenBinding.listView.layoutManager = LinearLayoutManager(this)
        imageAdapter = ImageAdapter()
        resultScreenBinding.listView.adapter = imageAdapter


        initObserver()

    }

    private fun initObserver() {
        val data = imageLoadViewModel.searchImage("Tiger", 1, 20, BuildConfig.FLICKR_API_KEY)


        data.observe(this, Observer {

            if (it.photos.photo.size > 0) {

                imageAdapter.setListData(it.photos.photo)
            }
        })

    }
}
