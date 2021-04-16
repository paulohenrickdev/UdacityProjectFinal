package com.example.udacityprojectfinal

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun setVisibility(view: View, loading: Boolean){
    if(loading){
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}