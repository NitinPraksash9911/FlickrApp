package com.example.nitinflicker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.repository.GetImageRepo
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Nitin  on 2020-03-11.
 */
class ImageLoadViewModel : ViewModel() {

    private var loadImageRepo = GetImageRepo.getInstanceOfRepo()

    var photoLiveData = MutableLiveData<List<Photo>>()
    private var compositeDisposable = CompositeDisposable()


    fun searchImage(searchTag: String, pageNo: Int, perPage: Int, apiKey: String) {

        compositeDisposable.add(loadImageRepo.searchImage(searchTag, pageNo, perPage, apiKey))

        loadImageRepo.data.observeForever {

            photoLiveData.value = it
        }


    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }


}