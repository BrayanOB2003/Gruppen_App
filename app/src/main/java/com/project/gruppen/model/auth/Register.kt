package com.project.gruppen.model.auth

import com.project.gruppen.model.User
import com.project.gruppen.repositories.uthentication.RegisterRepository
import kotlinx.coroutines.runBlocking

class Register {

    fun registerUser(name: String, email: String, password: String): Boolean {
        val auth = RegisterRepository()
        var successs: Boolean

        runBlocking {
            successs = auth.registerUser(email, password, name)
        }

        return successs
    }
}