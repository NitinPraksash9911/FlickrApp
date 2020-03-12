package com.example.nitinflicker.adapter

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.repository.GetImageRepo
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by   on 2020-03-12.
 */
class ItemSourceFactory(
    var compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, Photo>() {

    val mutableLiveData = MutableLiveData<PageKeyedDataSource<Int, Photo>>()


    override fun create(): DataSource<Int, Photo> {

        val itemDataSource = ItemDataSource(compositeDisposable)
        mutableLiveData.postValue(itemDataSource)
        return itemDataSource
    }
}