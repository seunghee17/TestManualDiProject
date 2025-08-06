package com.example.testexampleproject.app.di

import android.content.Context
import com.example.testexampleproject.data.network.adapter.ApiResultCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule(private val appContainer: AppModule) {
    val BASE_URL = "https://33387784-217b-4738-ab6d-a5e1fa9c92f3.mock.pstmn.io"

    fun provideOkHttpClient(
        context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(ApiResultCallAdapterFactory())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}