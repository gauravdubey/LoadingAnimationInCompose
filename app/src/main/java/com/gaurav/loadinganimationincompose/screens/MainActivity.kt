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
import com.gaurav.loadinganimationincompose.component.CustomToolBar
import com.gaurav.loadinganimationincompose.ui.theme.LoadingAnimationInComposeTheme

class MainActivity : ComponentActivity() { // Yellow color bracket
    override fun onCreate(savedInstanceState: Bundle?) { // Green color bracket
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { // Blue color bracket
            LoadingAnimationInComposeTheme { // Purple color bracket
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
                LoaderIndicatorScreen()
            }
        }
    )
}

