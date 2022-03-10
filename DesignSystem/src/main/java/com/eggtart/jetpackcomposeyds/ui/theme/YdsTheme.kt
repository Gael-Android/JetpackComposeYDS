package com.eggtart.jetpackcomposeyds.ui.theme

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.LocalTypography
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsTypography
import com.eggtart.jetpackcomposeyds.ui.theme.rule.*

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

    val spacing: Spacing
        @Composable
        @ReadOnlyComposable
        get() = LocalSpacing.current
}

// provider
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun YdsTheme(
    colors: YdsColors = YdsTheme.colors,
    typography: YdsTypography = YdsTheme.typography,
    rounding: Shapes = YdsTheme.rounding,
    boarder: Boarder = YdsTheme.boarder,
    spacing: Spacing = YdsTheme.spacing,
    content: @Composable () -> Unit
) {

    // creating a new object for colors to not mutate the initial colors set when updating the values
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typography,
        LocalRounding provides rounding,
        LocalBoarder provides boarder,
        LocalSpacing provides spacing,
        LocalMinimumTouchTargetEnforcement provides false, // Jetpack compose 1.1.0 에서의 최소터치크기(48.dp * 48.dp) 제한을 풉니다
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