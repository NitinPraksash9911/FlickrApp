package com.example.nitinflicker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.repository.ItemSourceFactory
import com.example.nitinflicker.utils.AppConstant
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Nitin  on 2020-03-12.
 */
class DataViewModel : ViewModel() {

    private var compositeDisposable = CompositeDisposable()
    var itemPageList: LiveData<PagedList<Photo>>
    var liveDataSource: LiveData<PageKeyedDataSource<Int, Photo>>
    var searchData = MutableLiveData<String>()

    init {
        val itemDatasourcefactory =
            ItemSourceFactory(
                "",
                compositeDisposable
            )
        liveDataSource = itemDatasourcefactory.mutableLiveData

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(AppConstant.PAGE_ITEM)
            .setInitialLoadSizeHint(AppConstant.PAGE_ITEM * 2)
            .build()


        itemPageList = Transformations.switchMap(searchData) {
            LivePagedListBuilder(itemDatasourcefactory.apply {
                this.tag = it

            }, config).build()
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }



}