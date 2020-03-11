package com.example.nitinflicker.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.nitinflicker.BuildConfig
import com.example.nitinflicker.model.FlickrData
import com.example.nitinflicker.network.APIAccess
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Nitin  on 2020-03-11.
 */
class GetImageRepo {

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


    fun searchImage(searchTag: String, pageNo: Int, perPage: Int, apiKey:String): MutableLiveData<FlickrData> {

        val photoLiveData = MutableLiveData<FlickrData>()

        val callImageRepo = APIAccess.getPostService()
            ?.getImageItemList(searchTag,pageNo,perPage,apiKey)

        callImageRepo?.enqueue(object : Callback<FlickrData> {
            override fun onResponse(
                call: Call<FlickrData>?,
                response: Response<FlickrData>
            ) {

                photoLiveData.value = response.body()
                Log.d("apicall", response.body()!!.photos.total)
            }

            override fun onFailure(call: Call<FlickrData>?, t: Throwable?) {

                Log.d("apicall", t?.message)

                photoLiveData.value = null

            }
        })

        return photoLiveData

    }
}