package com.example.nitinflicker.network

import com.example.nitinflicker.model.FlickrData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageWebService {

    @GET("rest/?method=flickr.photos.search&format=json&nojsoncallback=1")
    fun getImageItemList(
        @Query("tags") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("api_key") apikey: String
    ): Call<FlickrData>
}