package com.example.internetapiapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.internetapiapp.network.MarsItem
import com.example.internetapiapp.network.RestApi
import kotlinx.coroutines.launch

enum class MarsApiStatus{LOADING,ERROR,DONE}
class ApiViewModel : ViewModel() {
    private val _status = MutableLiveData<MarsApiStatus>(MarsApiStatus.LOADING)
    val status :LiveData<MarsApiStatus> = _status


    private val _properties = MutableLiveData<List<MarsItem>>()
    val properties : LiveData<List<MarsItem>> = _properties

    init {
        loadProperties()
    }

    private fun loadProperties() {
        viewModelScope.launch {
            try {
                _properties.value = RestApi.retrofitService.getRealStateProperties()
                _status.value = MarsApiStatus.DONE
            } catch (e:Exception){
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()
                Log.e("Network Error",e.message.toString())
            }
        }
    }
}