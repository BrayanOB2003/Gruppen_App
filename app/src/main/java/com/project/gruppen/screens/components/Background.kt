package com.project.gruppen.screens.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TriangularBackground(
    backgroundColor: Color = Color.Blue,
    triangleColor: Color = Color.White,
    triangleSize: Float = 150f,
    borderRadius: Float = 8f
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(color = backgroundColor)
            drawTriangles(triangleColor, triangleSize, borderRadius)
        }
    }
}

private fun DrawScope.drawTriangles(
    triangleColor: Color,
    triangleSize: Float,
    borderRadius: Float
) {
    val triangleSizePx = triangleSize.dp.toPx()
    val borderRadiusPx = borderRadius.dp.toPx()

    for (i in 0 until size.width.toInt() step triangleSizePx.toInt()) {
        for (j in 0 until size.height.toInt() step triangleSizePx.toInt()) {
            val path = Path().apply {
                moveTo(i.toFloat(), j.toFloat())
                lineTo(i.toFloat() + triangleSizePx, j.toFloat())
                lineTo(i.toFloat(), j.toFloat() + triangleSizePx)
                close()
            }
            drawPath(
                path = path,
                color = triangleColor,
                style = Fill,
                alpha = 0.8f
            )
        }
    }
}

@Preview
@Composable
fun TriangularBackgroundPreview() {
    TriangularBackground()
}