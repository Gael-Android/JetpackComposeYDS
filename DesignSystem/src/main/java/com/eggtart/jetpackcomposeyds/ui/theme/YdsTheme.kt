package com.eggtart.jetpackcomposeyds.ui.theme

import androidx.compose.material.Shapes
import androidx.compose.runtime.*

object YdsTheme {

    val colors: YdsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: YdsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current
}


@Composable
fun YdsTheme(
    colors: YdsColors = YdsTheme.colors,
    typography: YdsTypography = YdsTheme.typography,
    shapes: Shapes = YdsTheme.shapes,
    content: @Composable () -> Unit
) {
// creating a new object for colors to not mutate the initial colors set when updating the values
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
    ) {
        content()
    }
}