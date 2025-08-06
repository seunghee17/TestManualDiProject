package com.example.testexampleproject.app.di

import android.content.Context
import com.example.testexampleproject.data.network.adapter.ApiResultCallAdapterFactory
import com.example.testexampleproject.data.network.service.AuthService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule() {
    val BASE_URL = "https://33387784-217b-4738-ab6d-a5e1fa9c92f3.mock.pstmn.io"


    private val okHttpClient = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(ApiResultCallAdapterFactory())
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val authService: AuthService by lazy {
        retrofit.create(AuthService::class.java)
    }

}