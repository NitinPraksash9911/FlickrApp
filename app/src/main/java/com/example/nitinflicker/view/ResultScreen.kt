package com.example.nitinflicker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.nitinflicker.R
import com.example.nitinflicker.adapter.ImageListAdapter
import com.example.nitinflicker.databinding.ActivityResultScreenBinding
import com.example.nitinflicker.utils.AppConstant
import com.example.nitinflicker.viewmodel.DataViewModel

class ResultScreen : AppCompatActivity() {

    lateinit var dataViewModel: DataViewModel
    lateinit var imageListAdapter: ImageListAdapter
    lateinit var resultScreenBinding: ActivityResultScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultScreenBinding = DataBindingUtil.setContentView(this, R.layout.activity_result_screen)

        //initialization
        init()
    }

    fun init() {
        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModel.searchData.value = intent.getStringExtra(AppConstant.TAG)
        resultScreenBinding.listView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        imageListAdapter = ImageListAdapter()
        resultScreenBinding.listView.adapter = imageListAdapter

        dataViewModel.itemPageList.observe(this, Observer {

            imageListAdapter.submitList(it)

        })
    }


}
