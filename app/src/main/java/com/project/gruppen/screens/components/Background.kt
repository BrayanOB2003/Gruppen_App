package com.project.gruppen.screens.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ImageBackground(
    drawableId: Int,
    content: @Composable () -> Unit
) {
    val backgroundImage = painterResource(drawableId)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp)
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize().align(Alignment.Center),
            contentScale = ContentScale.Crop,
        )
        content()
    }
}