package com.example.di_canvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.example.di_canvas.ui.theme.DI_CanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DI_CanvasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    createCanvas()
                }
            }
        }
    }
}

@Composable
fun createCanvas() {
    val brush = Brush.linearGradient(listOf(Color.Red, Color.Blue))
    Canvas(
        modifier = Modifier.fillMaxSize().background(brush)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawCircle(
            color = Color.Red,
            radius = 400f,
            style = Stroke(width = 15f, cap = StrokeCap.Round),
            center = Offset(x = canvasWidth/2, y = canvasHeight/3)
        )
    }
}