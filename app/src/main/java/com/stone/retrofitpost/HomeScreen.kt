package com.stone.retrofitpost

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stone.retrofitpost.APi.Posts


@Composable
fun MovieItem(posts: Posts) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .padding(8.dp, 4.dp)) {
        Surface(){
            Column {
                Text(text =posts.id.toString(), fontSize = 20.sp, color = Color.DarkGray )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = posts.title, fontSize = 15.sp, fontStyle = FontStyle.Italic)
            }
        }
    }
}

@Composable
fun Recycler(posts:List<Posts>) {
    LazyColumn {
        itemsIndexed(items = posts){index, item ->
            MovieItem(item)
        }
    }

}

