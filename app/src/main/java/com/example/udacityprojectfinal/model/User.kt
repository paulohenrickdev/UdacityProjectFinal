package com.example.udacityprojectfinal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Long,
    val login: String,
    val name: String,
    val followers: String,
    val following: String,
    val avatar_url: String,
    val location: String,
    val public_repos: String
) : Parcelable