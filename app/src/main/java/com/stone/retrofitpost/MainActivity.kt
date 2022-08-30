package com.stone.retrofitpost

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.stone.retrofitpost.APi.Posts
import com.stone.retrofitpost.Responses.ApiStates
import com.stone.retrofitpost.Responses.ApiStates.Success
import com.stone.retrofitpost.ui.theme.REtrofitPostTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope= rememberCoroutineScope()
val posts by viewModel.myUiState.collectAsState()
            val isloading by viewModel.isLoading.collectAsState()
            val iserror by viewModel.isError.collectAsState()
            REtrofitPostTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

//  when{
//      isloading->{
//          Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
//              CircularProgressIndicator()
//          }
//      }
// else->

     Getdata(posts )
 }
  }

    }

} }

@Composable
fun Getdata(apiStates: ApiStates<List<Posts>?>) {

   when(apiStates){
    is Success->{
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.Cyan)) {
            Recycler(posts = apiStates.data!!)

        }
    }
    ApiStates.Empty -> {
        Column(Modifier.fillMaxSize(),Arrangement.Center,Alignment.CenterHorizontally) {
            Text(text = " Loading ", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        }
    }
    is ApiStates.Failure -> {
        Text(text = (apiStates .msg))
    }
    ApiStates.Loading -> {
        Column(Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            

        CircularProgressIndicator(color = Color.Blue)
        }
    }
       else -> {}
   }

}

