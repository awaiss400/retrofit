package com.stone.retrofitpost.APi

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    companion object{
        const val BASE_URL="https://jsonplaceholder.typicode.com/"
    }
    @GET("/posts")
    suspend fun GetPosts():Response<List<Posts>>
@GET("/posts/1/comments")
    suspend fun GetPoststwo():Response<List<Posts>>

    @POST("/posts")
    suspend fun Postdata(@Body post: Posts):Response<Posts>
    }