package com.pixabay.livedata.models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pixabay.livedata.retrofit.PixabayImageApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageDataViewModel : ViewModel() {

    var imageDataObserver : MutableLiveData<ImageDataModel>;

    init {
        imageDataObserver = MutableLiveData();
    }


    fun fetchDataFromUrl(url : String = PixabayImageApi.BASEURL){

        viewModelScope.launch(Dispatchers.IO) {

            PixabayImageApi.getApi(url).create(PixabayImageApi.callingApi::class.java)
                .getImages().enqueue(object : Callback<ImageDataModel> {
                    override fun onResponse(
                        call: Call<ImageDataModel>,
                        response: Response<ImageDataModel>
                    ) {
                        Log.e("TAG","responce:")
                        imageDataObserver.postValue(response.body())
                    }

                    override fun onFailure(call: Call<ImageDataModel>, t: Throwable) {
                    }

                })

        }

    }

}