package com.example.something

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.something.models.SignUpResponse
import com.example.something.models.User
import com.example.something.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {

    private val _responseLiveData = MutableLiveData<SignUpResponse>().apply {
        SignUpResponse(null, null, null, null, null)
    }
    val responseLiveData: MutableLiveData<SignUpResponse> = _responseLiveData


    fun init(email: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                signUp(email, password)
            }
        }
    }

    private suspend fun signUp(email: String, password: String) {
        val response = RetrofitService.retrofitService.signUp(User(email, password))
        if (response.isSuccessful) {
            val res = response.body()
           _responseLiveData.postValue(res)
        } else {
            response.code()
            Log.d("Response", response.toString())
        }
    }
}
