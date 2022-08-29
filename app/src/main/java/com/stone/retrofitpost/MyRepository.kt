package com.stone.retrofitpost

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.stone.retrofitpost.APi.ApiService
import com.stone.retrofitpost.APi.Posts
import com.stone.retrofitpost.Responses.ApiStates
import com.stone.retrofitpost.Responses.result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(val apiService: ApiService)
{
    fun getpost()= result {
        apiService.GetPosts()
}
    fun getposttwo()= result {
        apiService.GetPoststwo()
    }


}


