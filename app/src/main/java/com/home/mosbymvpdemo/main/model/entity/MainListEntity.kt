package com.home.mosbymvpdemo.main.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainListEntity(
    val date: String,
    val imageUrl: String,
    val title: String,
    val prompt: String,
    val content: String
) : Parcelable