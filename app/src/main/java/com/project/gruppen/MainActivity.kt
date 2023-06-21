package com.project.gruppen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.project.gruppen.ui.LoginActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchLoginActivity()
    }

    private fun launchLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Opcional, si deseas cerrar MainActivity después de iniciar LoginActivity
    }
}