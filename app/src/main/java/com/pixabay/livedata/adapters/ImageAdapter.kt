package com.pixabay.livedata.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pixabay.livedata.databinding.AdpImagedataBinding
import com.pixabay.livedata.models.ImageDataModel

class ImageAdapter(var data : ImageDataModel) : RecyclerView.Adapter<ImageAdapter.vHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vHolder {
        context = parent.context;
        return vHolder(AdpImagedataBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: vHolder, position: Int) {
        holder.setData(position);
    }

    override fun getItemCount(): Int {
        return data.hits.size
    }

    inner class vHolder(var binding: AdpImagedataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setData(position: Int) {
            Glide.with(context).load(data.hits.get(position).previewURL).into(binding.iv);
        }
    }


}