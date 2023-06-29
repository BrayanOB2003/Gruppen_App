package com.project.gruppen.navigation

sealed class AppScreens(val route: String){
    object LoginScreen: AppScreens("login_screen")
    object RegisterScreen: AppScreens("register_screen")
}
