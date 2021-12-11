package com.eggtart.jetpackcomposeyds.ui.theme

import androidx.compose.material.Shapes
import androidx.compose.runtime.*
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.LocalTypography
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsTypography
import com.eggtart.jetpackcomposeyds.ui.theme.rule.Boarder
import com.eggtart.jetpackcomposeyds.ui.theme.rule.LocalBoarder
import com.eggtart.jetpackcomposeyds.ui.theme.rule.LocalRounding

object YdsTheme {

    val colors: YdsColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: YdsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val rounding: Shapes
        @Composable
        @ReadOnlyComposable
        get() = LocalRounding.current

    val boarder: Boarder
        @Composable
        @ReadOnlyComposable
        get() = LocalBoarder.current
}

// provider
@Composable
fun YdsTheme(
    colors: YdsColors = YdsTheme.colors,
    typography: YdsTypography = YdsTheme.typography,
    rounding: Shapes = YdsTheme.rounding,
    boarder: Boarder = YdsTheme.boarder,
    content: @Composable () -> Unit
) {
// creating a new object for colors to not mutate the initial colors set when updating the values
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalRounding provides rounding,
        LocalBoarder provides boarder,
    ) {
        content()
    }
}