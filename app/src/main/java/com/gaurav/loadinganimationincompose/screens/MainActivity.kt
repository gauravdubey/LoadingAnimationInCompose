package com.gaurav.loadinganimationincompose.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gaurav.loadinganimationincompose.component.BouncingBallLoading
import com.gaurav.loadinganimationincompose.component.CircularLoadingExample
import com.gaurav.loadinganimationincompose.component.CustomToolBar
import com.gaurav.loadinganimationincompose.component.DotsLoadingIndicator
import com.gaurav.loadinganimationincompose.component.LinearLoadingExample
import com.gaurav.loadinganimationincompose.component.ShimmerLoadingEffect
import com.gaurav.loadinganimationincompose.component.ThreeBouncingBalls
import com.gaurav.loadinganimationincompose.component.TripleOrbitLoadingAnimation
import com.gaurav.loadinganimationincompose.ui.theme.LoadingAnimationInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoadingAnimationInComposeTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            CustomToolBar()
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
//                CircularLoadingExample()
//                LinearLoadingExample()
//                ShimmerLoadingEffect(true)
//                DotsLoadingIndicator()
//                BouncingBallLoading()
//                ThreeBouncingBalls()
                TripleOrbitLoadingAnimation()
            }
        }
    )
}
