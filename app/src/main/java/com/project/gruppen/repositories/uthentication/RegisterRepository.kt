package com.project.gruppen.repositories.uthentication

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.Lifecycling
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.project.gruppen.R
import com.project.gruppen.model.User
import com.project.gruppen.screens.components.ToastMessage
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RegisterRepository() {

    private val auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore
    suspend fun registerUser(email: String, password: String, name: String): Boolean = suspendCoroutine { continuation ->

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if(task.isSuccessful){
                    continuation.resume(true)
                } else {
                    continuation.resume(false)
                }
            }
    }
}