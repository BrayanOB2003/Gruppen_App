package com.project.gruppen.model.auth

import com.project.gruppen.repositories.uthentication.LoginRepository
import com.project.gruppen.repositories.uthentication.RegisterRepository

class Login {
    fun loginUser(email: String, password: String, callback: (Boolean) -> Unit) {
        val auth = LoginRepository()
        auth.loginUser(email, password, callback)
    }
}