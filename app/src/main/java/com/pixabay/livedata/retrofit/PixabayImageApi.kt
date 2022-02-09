package com.pixabay.livedata.retrofit

import com.pixabay.livedata.models.ImageDataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class PixabayImageApi {

    interface callingApi{
        @GET("api")
        fun getImages(@Query("key") key : String = "14664597-d9bfbdb977aa7d2ad856aa190") : Call<ImageDataModel>;
    }

    companion object {

//        var BASEURL = "https://pixabay.com/api/?key=14664597-d9bfbdb977aa7d2ad856aa190";
        var BASEURL = "https://pixabay.com/";

        fun getApi(url: String): Retrofit {

            return Retrofit.Builder().baseUrl(url)
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}