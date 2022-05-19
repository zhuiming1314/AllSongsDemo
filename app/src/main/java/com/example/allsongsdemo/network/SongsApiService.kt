package com.example.allsongsdemo.network

import com.example.allsongsdemo.Song
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

enum class SongsApiFilter(val value: String) {
    SHOW_RENT("rent"),
    SHOW_BUY("buy"),
    SHOW_ALL("all")
}
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SongsApiService {

    @GET("realestate")
    suspend fun getSong(@Query("filter") type: String): List<Song>

}

object SongsApi {
    val retrofitService : SongsApiService by lazy {
        retrofit.create(SongsApiService::class.java)
    }
}