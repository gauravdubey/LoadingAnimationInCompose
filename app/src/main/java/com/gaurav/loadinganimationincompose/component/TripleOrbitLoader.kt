package com.gaurav.loadinganimationincompose.component

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gaurav.loadinganimationincompose.ui.theme.LoadingAnimationInComposeTheme

private const val PADDING_PERCENTAGE_OUTER_CIRCLE = 0.15f
private const val PADDING_PERCENTAGE_INNER_CIRCLE = 0.3f
private const val POSITION_START_OFFSET_OUTER_CIRCLE = 90f
private const val POSITION_START_OFFSET_INNER_CIRCLE = 135f

@Composable
fun TripleOrbitLoadingAnimation(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
        ),
        label = "rotation animation"
    )
    var width by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Triple Orbit Loader",
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

        Box(
            modifier = modifier
                .size(100.dp)
                .onSizeChanged {
                    width = it.width
                },
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                strokeWidth = 1.dp,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationZ = rotation
                    }
            )
            CircularProgressIndicator(
                strokeWidth = 1.dp,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        with(LocalDensity.current) {
                            (width * PADDING_PERCENTAGE_INNER_CIRCLE).toDp()
                        }
                    )
                    .graphicsLayer {
                        rotationZ = rotation + POSITION_START_OFFSET_INNER_CIRCLE
                    }
            )
            CircularProgressIndicator(
                strokeWidth = 1.dp,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        with(LocalDensity.current) {
                            (width * PADDING_PERCENTAGE_OUTER_CIRCLE).toDp()
                        }
                    )
                    .graphicsLayer {
                        rotationZ = rotation + POSITION_START_OFFSET_OUTER_CIRCLE
                    }
            )
        }

        Spacer(modifier=Modifier.size(30.dp))
        PulseAnimation()
    }
}

@Preview(
    showBackground = true
)
@Composable
private fun TripleOrbitLoadingAnimationPreview() {
    LoadingAnimationInComposeTheme {
        TripleOrbitLoadingAnimation(
            modifier = Modifier
                .size(100.dp)
        )
    }
}