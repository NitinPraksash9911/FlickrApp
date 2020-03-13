package com.example.nitinflicker.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
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


        //action bar
        setActionBar()

        //initialization
        init()
    }

    private fun setActionBar() {
        val actionbar = supportActionBar
        actionbar!!.title = getString(R.string.galllery)
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    private fun init() {
        dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModel.searchData.value = intent.getStringExtra(AppConstant.TAG)
        resultScreenBinding.listView.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        imageListAdapter = ImageListAdapter()
        resultScreenBinding.listView.adapter = imageListAdapter

        //data observer
        initObserver()

    }

    private fun initObserver() {
        dataViewModel.itemPageList.observe(this, Observer {

            imageListAdapter.submitList(it)

        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
