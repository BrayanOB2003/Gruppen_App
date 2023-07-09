package com.project.gruppen.controllers

import com.project.gruppen.model.Home
import com.project.gruppen.model.User

class HomeController {
    lateinit var home: Home

    fun logInUser(currentUser: User){
        home = Home(currentUser)
    }
}