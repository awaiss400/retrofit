package com.stone.retrofitpost.Responses

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

sealed class  ApiStates<out  T>{
    data class Success<out R>(val data:R?):ApiStates<R>()
    data class Failure(val msg:String):ApiStates<Nothing>()
    object Loading:ApiStates<Nothing>()
    object Empty:ApiStates<Nothing>()

}

















































