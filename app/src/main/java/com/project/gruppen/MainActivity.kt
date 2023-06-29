package com.project.gruppen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.project.gruppen.navigation.AppNavigation
import com.project.gruppen.screens.Login
import com.project.gruppen.screens.Register

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AppNavigation()
        }
    }
}