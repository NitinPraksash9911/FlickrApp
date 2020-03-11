package com.example.nitinflicker.repository

import android.util.Log
import com.example.nitinflicker.model.FlickrData
import com.example.nitinflicker.model.Photo
import com.example.nitinflicker.network.APIAccess
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.TimeUnit


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


    fun searchImage(searchTag: String, pageNo: Int, perPage: Int, apiKey:String): Observable<ArrayList<Photo>> {

        var data = ArrayList<Photo>()

        val callImageRepo = APIAccess.getPostService()
            ?.getImageItemList("cat",1,20,"fe15b47ed990b3cd69cb4d27130d9876")

        callImageRepo?.enqueue(object : Callback<FlickrData> {
            override fun onResponse(
                call: Call<FlickrData>?,
                response: Response<FlickrData>
            ) {

                data= response.body()!!.photos.photo
                Log.d("apicall", response.body()!!.photos.total)
            }

            override fun onFailure(call: Call<FlickrData>?, t: Throwable?) {

                Log.d("apicall", t?.message)

//                data.addAll(arrayListOf())


            }
        })

        return Observable.just(data)

    }
}