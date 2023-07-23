package com.project.gruppen.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.project.gruppen.model.Group
import com.project.gruppen.model.Member

@Preview
@Composable
fun Home(){
    HomeScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(
        title = { Text("Mi App de Grupos") },
        actions = {
            IconButton(onClick = { /* Acción al hacer clic */ }) {
                Icon(Icons.Default.Add, contentDescription = "Agregar grupo")
            }
        }
    )
}


@Composable
fun GroupCard(group: Group) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = group.name, style = TextStyle(fontSize = 18.sp))
            Text(text = group.description, style = TextStyle(fontSize = 14.sp, color = Color.Gray))
        }
    }
}

@Composable
fun HomeContent() {
    val groupList = listOf<Group>(
        Group("1", "Grupo 1", "Descripción del Grupo 1", mutableListOf(Member("1", "Líder 1", "Líder"))),
        Group("2", "Grupo 2", "Descripción del Grupo 2", mutableListOf(Member("2", "Líder 2", "Líder"))),
    )

    LazyColumn {
        items(items = groupList) { group ->
            GroupCard(group)
        }
    }
}


@Composable
fun HomeBottomNavigation() {
    // Implementa la navegación y las acciones para acceder al perfil y las invitaciones aquí
    // Puedes usar BottomNavigation o cualquier otra interfaz de usuario adecuada.
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { HomeTopBar() },
        bottomBar = { HomeBottomNavigation() }
    ){ padding ->
        Column(Modifier.padding(padding)) {
            HomeContent()
        }
    }
}
