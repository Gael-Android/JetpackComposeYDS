package com.eggtart.jetpackcomposeyds.ui.theme.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.eggtart.jetpackcomposeyds.R

val fonts = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, weight = FontWeight.Normal),
    Font(R.font.spoqa_han_sans_neo_medium, weight = FontWeight.Medium),
    Font(R.font.spoqa_han_sans_neo_bold, weight = FontWeight.Bold),
)

@Composable
fun dpToSp(dp: Dp) = with(LocalDensity.current) { dp.toSp() }

data class YdsTypography(
    val title1: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 36.4.sp
    ),
    val title2: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 31.2.sp
    ),
    val title3: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 26.sp
    ),
    val subTitle1: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 26.sp
    ),
    val subTitle2: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 26.sp
    ),
    val subTitle3: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 18.2.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 22.5.sp
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp
    ),
    val button0: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),
    val button1: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 16.sp
    ),
    val button2: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 14.sp
    ),
    val button3: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp
    ),
    val button4: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 12.sp
    ),
    val caption0: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 15.6.sp
    ),
    val caption1: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 15.6.sp
    ),
    val caption2: TextStyle = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 14.3.sp
    ),
)

internal val LocalTypography = staticCompositionLocalOf {
    YdsTypography()
}

