package com.example.nitinflicker.network


import com.example.nitinflicker.BuildConfig
import com.example.nitinflicker.utils.AppConstant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 * Created by Nitin  on 2020-03-11.
 */
object APIAccess {


    private var webService: ImageWebService? = null
    //---method return PostService
    fun getPostService(): ImageWebService? {
        if (webService == null) {
            val okHttpClient =
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val original = chain.request()
                        val request = original.newBuilder()
                            .addHeader("Content-Type", "application/json")
                            .method(original.method, original.body)
                            .build()
                        chain.proceed(request)
                    }
                    .build()


            /* create retrofit object **/
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            webService = retrofit.create(ImageWebService::class.java)
        }
        return webService
    }


}