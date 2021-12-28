package com.eggtart.jetpackcomposeyds.ui.theme

import androidx.compose.material.Shapes
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
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
        LocalDensity provides Density(
            // 시스템 fontSize 설정을 무시하는 유일한 방법은 밀도 개체를 재정의하고 fontScale을 1f로 설정하는 것입니다.
            // 그러나 이것은 강력히 권장하지 않으며 가능하면 Sp대신 사용하십시오 .
            LocalDensity.current.density, fontScale = 1f
        )
    ) {
        // 여기서 1.sp는 항상 1.dp와 같습니다.
        content()
    }
}