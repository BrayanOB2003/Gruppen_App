package com.project.gruppen.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.project.gruppen.screens.Home
import com.project.gruppen.screens.Login
import com.project.gruppen.screens.Register
import com.project.gruppen.screens.components.ExpandHorizontally
import com.project.gruppen.screens.components.SliceTransition

@Preview
@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route){
        composable(route = AppScreens.LoginScreen.route){
            Login(navController)
        }
        composable(route = AppScreens.RegisterScreen.route){
            Register(navController)
        }
        composable(route = AppScreens.HomeScreen.route){
            Home(navController)
        }
    }

}