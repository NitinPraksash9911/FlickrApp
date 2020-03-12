package com.example.nitinflicker.repository

import androidx.lifecycle.MutableLiveData
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.network.APIAccess
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*


/**
 * Created by Nitin  on 2020-03-11.
 */
class GetImageRepo {

    val data = MutableLiveData<ArrayList<Photo>>()

    /*singleton object*/
    companion object {
        var imageRepo: GetImageRepo? = null


        fun getInstanceOfRepo(): GetImageRepo {

            if (imageRepo == null) {
                imageRepo = GetImageRepo()
            }
            return imageRepo!!
        }
    }


    fun searchImage(searchTag: String, pageNo: Int, perPage: Int, apiKey: String): Disposable {
        val callImageRepo = APIAccess.getPostService()
            .getImageItemList(query = searchTag, page = pageNo, perPage = perPage, apikey = apiKey)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ flickr ->

                data.value = flickr.photos.photo as ArrayList<Photo>


            }, {

                data.value = arrayListOf()
            })


        return callImageRepo


    }
}