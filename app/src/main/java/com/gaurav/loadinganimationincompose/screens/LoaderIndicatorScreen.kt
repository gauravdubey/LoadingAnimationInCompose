package com.gaurav.loadinganimationincompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gaurav.loadinganimationincompose.component.CircularLoadingExample
import com.gaurav.loadinganimationincompose.component.DotsLoadingIndicator
import com.gaurav.loadinganimationincompose.component.LinearLoadingExample
import com.gaurav.loadinganimationincompose.component.LoadCircularLoader
import com.gaurav.loadinganimationincompose.component.PulseAnimation
import com.gaurav.loadinganimationincompose.component.ThreeBouncingBalls
import com.gaurav.loadinganimationincompose.component.TripleOrbitLoadingAnimation
import com.gaurav.loadinganimationincompose.ui.theme.LoadingAnimationInComposeTheme

@Composable
fun LoaderIndicatorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Loaders Demo",
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
        CircularLoadingExample()
        Spacer(modifier = Modifier.size(20.dp))
        DotsLoadingIndicator()
        Spacer(modifier = Modifier.size(10.dp))
        LinearLoadingExample()
        Spacer(modifier = Modifier.size(20.dp))
        ThreeBouncingBalls()
        Spacer(modifier = Modifier.size(20.dp))
        TripleOrbitLoadingAnimation()
        Spacer(modifier = Modifier.size(20.dp))
        PulseAnimation()
        Spacer(modifier = Modifier.size(20.dp))
        LoadCircularLoader(true)
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun LoaderIndicatorPreview() {
    LoadingAnimationInComposeTheme {
        LoaderIndicatorScreen()
    }
}