package com.example.testexampleproject.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.testexampleproject.app.di.AppModule
import com.example.testexampleproject.ui.theme.TestExampleProjectTheme

class MainActivity : ComponentActivity() {
    private val appModule: AppModule by lazy {
        (application as App).appModule
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestExampleProjectTheme {
                TestNavigation(appModule = appModule)
            }
        }
    }
}

