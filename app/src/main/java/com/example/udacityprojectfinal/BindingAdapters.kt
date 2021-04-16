package com.example.udacityprojectfinal

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:visibility")
fun setVisibility(view: View, loading: Boolean){
    if(loading){
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}

@BindingAdapter("imageUrl")
fun setPhotoUser(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}