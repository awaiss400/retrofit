package com.stone.retrofitpost

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stone.retrofitpost.APi.Posts
import com.stone.retrofitpost.Responses.ApiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val myRepository: MyRepository):ViewModel() {
//    var todolistresponse: MutableState<ApiStates<Any>> = mutableStateOf(ApiStates.Empty)
//    var posttodolistresponse:MutableState<ApiStates<Any>> = mutableStateOf(ApiStates.Empty)
//init {
//
//   gettodoList()
//    todolistresponse=posttodolistresponse
//
//}
//    fun gettodoList() {
//        viewModelScope.launch {
//            myRepository.getalltodos()
//                .onStart {
//                    todolistresponse.value = ApiStates.Loading
//                }.catch {
//                    todolistresponse.value = ApiStates.Failure(it.toString())
//                }.collect {
//                    todolistresponse.value = ApiStates.Success(it)
//                }
//
//        }
//    }
//    fun posttodoList(posts: Posts) {
//        viewModelScope.launch {
//     val response=  myRepository.popstalltodos(posts)
//         .onStart {
//             posttodolistresponse.value = ApiStates.Loading
//         }.catch {
//             posttodolistresponse.value = ApiStates.Failure(it.toString())
//         }.collect {
//             posttodolistresponse.value = ApiStates.Success(it)
//         }
//        }
val data=myRepository.getpost()
    val datatwo=myRepository.getposttwo()
}
