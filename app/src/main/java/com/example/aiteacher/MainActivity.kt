package com.example.aiteacher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.aiteacher.app.AppNavigation
import com.example.aiteacher.ui.theme.AiTeacherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AiTeacherTheme {
                AppNavigation(rememberNavController())
            }
        }
    }
}

