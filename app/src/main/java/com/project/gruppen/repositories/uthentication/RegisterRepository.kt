package com.project.gruppen.repositories.uthentication

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.project.gruppen.R
import com.project.gruppen.model.User
import com.project.gruppen.screens.components.ToastMessage

class RegisterRepository() {

    private val auth: FirebaseAuth = Firebase.auth

    fun registerUser(email: String, password: String, name: String, callBack: (User?) -> Unit) {
        var user: User? = null

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if(task.isSuccessful){
                    val id = task.result.user?.uid.toString()
                    user = User(id, name, email)
                    callBack(user)
                } else {
                    callBack(user)
                }
            }
    }
}