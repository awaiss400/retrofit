package com.stone.retrofitpost

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.stone.retrofitpost.APi.Posts
import com.stone.retrofitpost.Responses.ApiStates
import com.stone.retrofitpost.Responses.ApiStates.Success
import com.stone.retrofitpost.ui.theme.REtrofitPostTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val posts = Posts(123, 54, "dddddd", "dddd")
    val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope= rememberCoroutineScope()

            REtrofitPostTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    val x = viewModel.posttodoList(posts)


//                    when(y.value){
//                        is ApiStates.Success->{
//                            Toast.makeText(this, "uploaded", Toast.LENGTH_LONG).show()
//                        }
//                        ApiStates.Empty -> {
//                            Toast.makeText(this, "empty", Toast.LENGTH_LONG).show()
//
//                        }
//                        is ApiStates.Failure -> {   Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()
//                        }
//                        ApiStates.Loading -> {  Toast.makeText(this, "uloding", Toast.LENGTH_LONG).show()
//                        }
//                    }                    }
//                    Getdata(viewModel = viewModel)
val a=lifecycleScope.launchWhenStarted {
    viewModel.datatwo.collect{
    when(it){
        is Success->{
            Toast.makeText(this@MainActivity, "${it.data}", Toast.LENGTH_LONG).show()
        }
        ApiStates.Empty -> {
            Toast.makeText(this@MainActivity, "Empty", Toast.LENGTH_SHORT).show()

        }
        is ApiStates.Failure -> {
            Toast.makeText(this@MainActivity, it.msg, Toast.LENGTH_LONG).show()

        }
        ApiStates.Loading -> {

            Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show()

        }
    }
    }

}

                }
            }

        }
    }}




//@Composable
//fun Getdata(viewModel: MyViewModel) {
//
//
//        viewModel.data.collect{
//    when (it) {
//        is Success -> {
//            Recycler(posts = it.data!!)
////            Text(text = "heyyyyyyyyy")
//        }
//        is ApiStates.Loading -> {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CircularProgressIndicator(color = Color.Blue)
//
//            }
//        }
//        is ApiStates.Failure -> {
//
//            Text(text = it.msg)
//        }
//        is ApiStates.Empty -> {}
//    }
//
//    }}
