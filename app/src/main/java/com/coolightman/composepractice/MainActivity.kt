package com.coolightman.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.core.content.ContextCompat
import com.coolightman.composepractice.ui.instagram.ProfileScreen
import com.coolightman.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme() {
                ProfileScreen()
            }
        }
    }
}