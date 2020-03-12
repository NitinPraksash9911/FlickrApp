package com.example.nitinflicker.adapter

import androidx.paging.PageKeyedDataSource
import com.example.nitinflicker.BuildConfig
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.network.APIAccess
import com.example.nitinflicker.utils.AppConstant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by  Nitin on 2020-03-12.
 */
class ItemDataSource(var compositeDisposable: CompositeDisposable) :
    PageKeyedDataSource<Int, Photo>() {


    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {

        compositeDisposable.add(

            APIAccess.getPostService()
                .getImageItemList(
                    AppConstant.TAG,
                    AppConstant.FIRST_PAGE,
                    AppConstant.PAGE_ITEM,
                    BuildConfig.FLICKR_API_KEY
                )
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { flickr ->

                    callback.onResult(flickr.photos.photo, null, AppConstant.FIRST_PAGE + 1)

                }


        )


    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        compositeDisposable.add(
            APIAccess.getPostService()
                .getImageItemList(
                    AppConstant.TAG,
                    params.key,
                    AppConstant.PAGE_ITEM,
                    BuildConfig.FLICKR_API_KEY
                )
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { flickr ->

                    val key = if (params.key > 1) params.key + 1 else null

                    callback.onResult(flickr.photos.photo, key)


                }

        )

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        compositeDisposable.add(

            APIAccess.getPostService()
                .getImageItemList(
                    AppConstant.TAG,
                    params.key,
                    AppConstant.PAGE_ITEM,
                    BuildConfig.FLICKR_API_KEY
                )
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { flickr ->

                    val key = if (params.key > 1) params.key - 1 else null

                    callback.onResult(flickr.photos.photo, key)


                }

        )


    }
}