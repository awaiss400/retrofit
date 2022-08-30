package com.stone.retrofitpost

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stone.retrofitpost.APi.Posts
import com.stone.retrofitpost.Responses.ApiStates
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val myRepository: MyRepository):ViewModel() {
    var todolistresponse:MutableState<ApiStates<List<Posts>?>> = mutableStateOf(ApiStates.Empty)

    private val _myUiState = MutableStateFlow<ApiStates<List<Posts>?>>(ApiStates.Empty)
    val myUiState: StateFlow<ApiStates<List<Posts>?>> = _myUiState
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading
    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError


   init {
       getd()
   }
    private fun getd(){
        viewModelScope.launch {
            _isLoading.value=true
        try {
            myRepository.getpost().collect{
            _myUiState.value=it

        }}catch (e:Throwable){
_isError.value=true
        }
            _isLoading.value=false
        }}

}
