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
    suspend fun loginUser(email: String, password: String): User? = suspendCoroutine { continuation ->
        var user: User? = null
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val id = task.result.user?.uid.toString()
                    user = User(id, "name", email)
                    continuation.resume(user)
                } else {
                    continuation.resume(user)
                }
            }
    }
}