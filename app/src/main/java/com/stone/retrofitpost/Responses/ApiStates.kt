package com.stone.retrofitpost.Responses

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

sealed class  ApiStates<out  T>{
    data class Success<out T>(val data:T?):ApiStates<T>()
    data class Failure(val msg:String):ApiStates<Nothing>()
    object Loading:ApiStates<Nothing>()
    object Empty:ApiStates<Nothing>()

}
//fun handleres(apiStates: ApiStates<Any>){
//when(apiStates){
//    is ApiStates.Success->{
//
//    }
//    ApiStates.Empty ->  {
//
//    }
//    is ApiStates.Failure -> {
//
//    }
//    ApiStates.Loading -> {
//
//    }
//}
//}

















































