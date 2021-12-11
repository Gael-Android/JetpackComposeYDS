package com.eggtart.jetpackcomposeyds.ui.theme.rule

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

private val Rounding = Shapes(
    small = RoundedCornerShape(2.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(8.dp)
)

internal val LocalRounding = staticCompositionLocalOf { Rounding }