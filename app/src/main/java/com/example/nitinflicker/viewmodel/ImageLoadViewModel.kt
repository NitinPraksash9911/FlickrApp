package com.example.nitinflicker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nitinflicker.model.FlickrData
import com.example.nitinflicker.repository.GetImageRepo


/**
 * Created by Nitin  on 2020-03-11.
 */
class ImageLoadViewModel:ViewModel() {

    private var instanceOfImageRepo = GetImageRepo.getInstanceOfRepo()


    fun searchImage(searchTag: String, pageNo: Int, perPage: Int, apiKey:String): MutableLiveData<FlickrData> {

        return instanceOfImageRepo.searchImage(searchTag, pageNo, perPage, apiKey)

    }
}