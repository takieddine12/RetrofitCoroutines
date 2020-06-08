package com.example.learningproject.ApiRequest

import com.example.learningproject.model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AuthApi {

    @GET("posts")
    suspend fun getPosts() : List<model>


    companion object{
        fun getResponse() : AuthApi{
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(AuthApi::class.java)
        }
    }
}