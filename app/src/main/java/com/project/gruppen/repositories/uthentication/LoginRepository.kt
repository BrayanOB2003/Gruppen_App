package com.project.gruppen.repositories.uthentication

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.project.gruppen.model.User
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LoginRepository {

    private val auth: FirebaseAuth = Firebase.auth
    fun loginUser(email: String, password: String, callback: (Boolean) -> Unit) {
        var user: User? = null
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                callback(task.isSuccessful)
            }
    }
}