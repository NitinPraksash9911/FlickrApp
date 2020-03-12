package com.example.nitinflicker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nitinflicker.R
import com.example.nitinflicker.adapter.ImageAdapter
import com.example.nitinflicker.adapter.ListAdapter
import com.example.nitinflicker.databinding.ActivityResultScreenBinding
import com.example.nitinflicker.viewmodel.DataViewModel
import com.example.nitinflicker.viewmodel.ImageLoadViewModel

class ResultScreen : AppCompatActivity() {

    lateinit var imageLoadViewModel: ImageLoadViewModel
    lateinit var dataViewModel: DataViewModel
    lateinit var listAdapter: ListAdapter
    lateinit var imageAdapter: ImageAdapter
    lateinit var resultScreenBinding: ActivityResultScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_result_screen)

        //initialization
        init()
    }

    fun init() {
        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        resultScreenBinding.listView.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter()
        resultScreenBinding.listView.adapter = listAdapter

        dataViewModel.itemPageList.observe(this, Observer {

            listAdapter.submitList(it)
        })
    }

    private fun initOld() {
        resultScreenBinding.lifecycleOwner = this
        imageLoadViewModel = ViewModelProvider(this).get(ImageLoadViewModel::class.java)
        resultScreenBinding.listView.layoutManager = LinearLayoutManager(this)
        imageAdapter = ImageAdapter()
        resultScreenBinding.listView.adapter = imageAdapter
//        initObserver()


    }

    private fun initObserver() {
//        imageLoadViewModel.searchImage("Elephant", 1, 20, BuildConfig.FLICKR_API_KEY)
//
//        imageLoadViewModel.photoLiveData.observe(this, Observer {
//
//            if (it != null) {
//                imageAdapter.setListData(it as ArrayList<Photo>)
//            }
//
//        })


    }
}
