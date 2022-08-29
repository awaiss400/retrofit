package com.stone.retrofitpost

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stone.retrofitpost.APi.Posts
import com.stone.retrofitpost.Responses.ApiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val myRepository: MyRepository):ViewModel() {
    var todolistresponse:MutableState<ApiStates<List<Posts>?>> = mutableStateOf(ApiStates.Empty)
   init {
       getd()
   }
    private fun getd(){
        viewModelScope.launch {
        myRepository.getpost().collect{
            todolistresponse.value=it
        }
    }}

}
