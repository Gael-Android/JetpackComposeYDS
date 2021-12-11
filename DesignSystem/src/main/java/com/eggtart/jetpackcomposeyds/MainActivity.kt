package com.eggtart.jetpackcomposeyds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeYDSTheme {

            }
        }
    }
}


