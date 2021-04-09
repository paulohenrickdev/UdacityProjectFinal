package com.example.udacityprojectfinal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val login: String,
    val name: String,
    val followers: String,
    val following: String,
    val avatar_url: String,
    val email: String
) : Parcelable