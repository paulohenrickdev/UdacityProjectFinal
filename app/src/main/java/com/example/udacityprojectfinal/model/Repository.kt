package com.example.udacityprojectfinal.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repository(
    val id: Long,
    val name: String,
    val description: String?,
    val language: String
) : Parcelable