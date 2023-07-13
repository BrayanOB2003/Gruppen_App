package com.project.gruppen.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.project.gruppen.navigation.AppScreens
import com.project.gruppen.screens.components.Button


@Composable
fun Home(navController: NavController){
    Column() {
        Text(text = "It's home")
        Spacer(modifier = Modifier.height(50.dp))
        Button(text = "hello", onClick = {
            navController.navigate(AppScreens.LoginScreen.route)
        })
    }
}
