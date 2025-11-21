package com.example.ubeasiswa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ubeasiswa.ui.screens.UbeasiswaApp
import com.example.ubeasiswa.ui.theme.UBeasiswaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UBeasiswaTheme {
                UbeasiswaApp()
            }
        }
    }
}
