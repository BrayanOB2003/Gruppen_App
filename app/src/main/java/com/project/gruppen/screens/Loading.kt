package com.project.gruppen.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.gruppen.R

@Composable
fun LoadingScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Loading",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(
                color = colorResource(id = R.color.white),
                strokeWidth = 2.dp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Loading...",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}