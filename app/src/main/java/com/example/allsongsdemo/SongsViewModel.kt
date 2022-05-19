package com.example.allsongsdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allsongsdemo.network.SongsApi
import com.example.allsongsdemo.network.SongsApiFilter
import com.example.allsongsdemo.network.SongsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

enum class SongsApiStatus { LOADING, ERROR, DONE }
class SongsViewModel : ViewModel(){

    private val _songs = MutableLiveData<List<Song>>()
    val songs: LiveData<List<Song>>
        get() = _songs

    private val _status = MutableLiveData<SongsApiStatus>()
    val status: LiveData<SongsApiStatus>
        get() = _status

    init {
        getSongs(SongsApiFilter.SHOW_ALL)
    }
    private fun getSongs(filter: SongsApiFilter) {
        viewModelScope.launch {
            _status.value = SongsApiStatus.LOADING
            try {
                _status.value = SongsApiStatus.DONE
                _songs.value = SongsApi.retrofitService.getSong(filter.value)
            } catch (e: Exception) {
                _status.value = SongsApiStatus.ERROR
                _songs.value = ArrayList()
            }
        }
    }



}