package com.eggtart.jetpackcomposeyds.ui.theme.rule

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Boarder(
    val thin: Dp = minWidth,
    val normal: Dp = 1.dp,
    val thick: Dp = 8.dp,
)

internal val LocalBoarder = staticCompositionLocalOf { Boarder() }