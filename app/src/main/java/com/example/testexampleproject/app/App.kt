package com.example.testexampleproject.app
import android.app.Application
import com.example.testexampleproject.app.di.AppModule

class App: Application() {
    val appModule: AppModule by lazy {
        AppModule()
    }

    override fun onCreate() {
        super.onCreate()
    }
}