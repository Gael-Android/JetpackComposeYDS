package com.eggtart.jetpackcomposeyds.ui.theme.rule

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


//@Retention(AnnotationRetention.SOURCE)
//@IntDef(TWO, FOUR, EIGHT, TWELVE, SIXTEEN, TWENTY, TWENTY_FOUR, THIRTY_TWO, FORTY_EIGHT, SIXTY_FOUR)
//annotation class Spacing



data class Spacing(
    val two: Dp = 2.dp,
    val four: Dp = 4.dp,
    val eight: Dp = 8.dp,
    val twelve: Dp = 12.dp,
    val sixteen: Dp = 16.dp,
    val twenty: Dp = 20.dp,
    val twentyFour: Dp = 24.dp,
    val twentyTwo: Dp = 32.dp,
    val fortyEight: Dp = 48.dp,
    val sixtyFour: Dp = 64.dp,
    val leftAndRightSpacing: Dp = twenty,
    val fixedElementSpacing: Dp = sixteen,
)

internal val LocalSpacing = staticCompositionLocalOf { Spacing() }