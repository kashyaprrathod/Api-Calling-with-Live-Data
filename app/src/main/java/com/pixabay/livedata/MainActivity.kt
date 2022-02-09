package com.pixabay.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.pixabay.livedata.adapters.ImageAdapter
import com.pixabay.livedata.databinding.ActivityMainBinding
import com.pixabay.livedata.models.ImageDataModel
import com.pixabay.livedata.models.ImageDataViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        var liveData = ViewModelProvider(this).get(ImageDataViewModel::class.java);

        if(liveData.imageDataObserver.value == null){
            Log.e("TAG","is null")
            binding.dataLoaded= false;
            liveData.fetchDataFromUrl();
        }

        liveData.imageDataObserver.observe(this, Observer {
            Log.e("TAG","observer")
            binding.dataLoaded = true;
            setRecyclerView(it);
        })

    }

    private fun setRecyclerView(it: ImageDataModel?) {

        if(it != null){
            binding.rv.adapter = ImageAdapter(it)
            binding.rv.layoutManager = GridLayoutManager(this,2)
        }

    }


}