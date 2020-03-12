package com.example.nitinflicker.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.example.nitinflicker.model.Photo
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Nitin  on 2020-03-12.
 */
class ItemSourceFactory(
    var tag: String,
    var compositeDisposable: CompositeDisposable
) : DataSource.Factory<Int, Photo>() {

    val mutableLiveData = MutableLiveData<PageKeyedDataSource<Int, Photo>>()


    override fun create(): DataSource<Int, Photo> {

        val itemDataSource = ItemDataSource(
            compositeDisposable,
            tag
        )
        mutableLiveData.postValue(itemDataSource)
        return itemDataSource
    }
}