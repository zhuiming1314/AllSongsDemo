package com.example.allsongsdemo



import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double,
    val name: String = "Conqueror",
    val singer: String = "Empire Cast / Estelle") : Parcelable {
        val isRental
            get() = type == "rent"
    }



