package com.example.nitinflicker.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.repository.GetImageRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


/**
 * Created by Nitin  on 2020-03-11.
 */
class ImageLoadViewModel : ViewModel() {

    private var instanceOfImageRepo = GetImageRepo.getInstanceOfRepo()

     var photoLiveData = MutableLiveData<ArrayList<Photo>>()
    private var compositeDisposable = CompositeDisposable()


    fun searchImage(searchTag: String, pageNo: Int, perPage: Int, apiKey: String) {

        compositeDisposable.add(instanceOfImageRepo.searchImage(searchTag, pageNo, perPage, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<ArrayList<Photo>>(){
                override fun onComplete() {
                }

                override fun onNext(t: ArrayList<Photo>) {
                    photoLiveData.value = t

                }

                override fun onError(e: Throwable) {
                }

            }))

    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }



}