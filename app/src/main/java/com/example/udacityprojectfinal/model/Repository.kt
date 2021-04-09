package com.example.udacityprojectfinal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    val language: String,
    val description: String,
    val name: String
) : Parcelable