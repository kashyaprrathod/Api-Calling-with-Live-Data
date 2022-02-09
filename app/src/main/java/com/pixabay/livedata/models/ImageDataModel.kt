package com.pixabay.livedata.models

data class ImageDataModel(val hits: ArrayList<HitsModel>)
data class HitsModel(
    val id: String,
    val previewURL: String,
    val likes: String,
    val comments: String,
    val user_id : String
)