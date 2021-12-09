package com.eggtart.jetpackcomposeyds.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@Composable
fun JetpackComposeYDSTheme(
    content: @Composable() () -> Unit
) {
    YdsTheme(
        content = content
    )
}