package com.example.di_canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.di_canvas.ui.theme.DI_CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DI_CanvasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    createCanvas(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun createCanvas(modifier: Modifier) {
    val brush = Brush.linearGradient(listOf(Color.Red, Color.Blue))
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(brush)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val margenRect = 50f
        val ladoRect = 100f
        val trazoCirculo = 15f
        val radioCirculo = canvasWidth/2 - margenRect - trazoCirculo
        val tamanyoPunto = 20f

        drawPoints(
            points = listOf(
                Offset(x = canvasWidth/2, y = canvasHeight/2)
            ),
            pointMode = PointMode.Points,
            color = Color.White,
            strokeWidth = tamanyoPunto
        )

        drawCircle(
            color = Color.Red,
            radius = radioCirculo,
            style = Stroke(width = trazoCirculo, cap = StrokeCap.Round),
            center = Offset(x = canvasWidth/2, y = canvasHeight/2)
        )

        drawRect(
            color = Color.Blue,
            topLeft = Offset(x = margenRect, y = margenRect),
            size = Size(ladoRect, ladoRect)
        )

        drawRect(
            color = Color.Yellow,
            topLeft = Offset(x = canvasWidth - ladoRect - margenRect, y = margenRect),
            size = Size(ladoRect, ladoRect)
        )

        drawRect(
            color = Color.Red,
            topLeft = Offset(x = margenRect, y = canvasHeight - ladoRect - margenRect),
            size = Size(ladoRect, ladoRect)
        )

        drawRect(
            color = Color.Green,
            topLeft = Offset(x = canvasWidth - ladoRect - margenRect, y = canvasHeight - ladoRect - margenRect),
            size = Size(ladoRect, ladoRect)
        )
    }
}