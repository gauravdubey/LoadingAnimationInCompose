package com.gaurav.loadinganimationincompose.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun DotsLoadingIndicator() {
    val dots = listOf(".", "..", "...")
    var index by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(500)
            index = (index + 1) % dots.size
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Simple Dot Loading",
            modifier = Modifier
                .graphicsLayer(alpha = 0.99f) // Enables advanced drawing
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF6200EA), Color(0xFF03DAC5))
                    )
                )
                .padding(start = 40.dp, end = 40.dp, top = 5.dp, bottom = 5.dp),
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White // Text color set to transparent to enable gradient
        )
        Spacer(modifier = Modifier.size(100.dp))

        Text(
            text = "Typing ${dots[index]}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
    }
}
