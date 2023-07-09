package com.project.gruppen.model.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import com.project.gruppen.R
import com.project.gruppen.model.User
import com.project.gruppen.repositories.uthentication.RegisterRepository
import com.project.gruppen.screens.components.ToastMessage

class Register {

    fun registerUser(name: String, email:String, password: String): User? {
        var user: User? = null
        val auth = RegisterRepository()
        auth.registerUser(email, password, name) { newUser ->
            user = newUser
        }
        return user
    }
}