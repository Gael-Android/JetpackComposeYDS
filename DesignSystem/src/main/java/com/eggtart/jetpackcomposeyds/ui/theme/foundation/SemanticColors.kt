package com.eggtart.jetpackcomposeyds.ui.theme.foundation

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class ColorScheme(
    // Background
    val bgNormal: Color,
    val bgElevated: Color,
    val bgRecomment: Color,
    val bgSelected: Color,
    val bgPressed: Color,
    val bgNormalDark: Color,
    val bgElevatedDark: Color,

    // Text
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textDisabled: Color,
    val textBright: Color,
    val textPointed: Color,
    val textWarned: Color,

    // Dim

    val dimNormal: Color,
    val dimThick: Color,
    val dimThickBright: Color,

    // Border
    val borderThin: Color,
    val borderNormal: Color,
    val borderThick: Color,

    // Button
    val buttonNormal: Color,
    val buttonNormalPressed: Color,
    val buttonBG: Color,
    val buttonEmojiBG: Color,
    val buttonBright: Color,
    val buttonDisabled: Color,
    val buttonDisabledBG: Color,
    val buttonPoint: Color,
    val buttonPointPressed: Color,
    val buttonPointBG: Color,
    val buttonWarned: Color,
    val buttonWarnedPressed: Color,
    val buttonWarnedBG: Color,

    // BottomBar
    val bottomBarNormal: Color,
    val bottomBarSelected: Color,

    // InputField
    val inputFieldNormal: Color,
    val inputFieldElevated: Color,


    // Toast
    val toastBG: Color,


    // Tooltip
    val tooltipBG: Color,
    val tooltipPoint: Color,

    // Pressed
    val pressed: Color,

    // Shadow
    val shadowThin: Color,
    val shadowNormal: Color,

    // MonoItem
    val monoItemPrimary: Color,
    val monoItemBG: Color,
    val monoItemText: Color,

    // LimeTag
    val limeItemPrimary: Color,
    val limeItemBG: Color,

    // GreenItem
    val greenItemPrimary: Color,
    val greenItemBG: Color,
    val greenItemText: Color,

    // EmeraldItem
    val emeraldItemPrimary: Color,
    val emeraldItemBG: Color,
    val emeraldItemText: Color,


    // AquaItem
    val aquaItemPrimary: Color,
    val aquaItemBG: Color,
    val aquaItemText: Color,

    // BlueItem
    val blueItemPrimary: Color,
    val blueItemBG: Color,
    val blueItemText: Color,

    // IndigoItem
    val indigoItemPrimary: Color,
    val indigoItemBG: Color,
    val indigoItemText: Color,


    // VioletItem
    val violetItemPrimary: Color,
    val violetItemBG: Color,
    val violetItemText: Color,


    // PurpleItem
    val purpleItemPrimary: Color,
    val purpleItemBG: Color,
    val purpleItemText: Color,

    // PinkItem
    val pinkItemPrimary: Color,
    val pinkItemBG: Color,
    val pinkItemText: Color,
)

val lightThemeColors = ColorScheme(
// Background
    bgNormal = white000,
    bgElevated = white000,
    bgRecomment = gray050,
    bgSelected = gray100,
    bgPressed = gray100,
    bgNormalDark = realBlack,
    bgElevatedDark = realBlack,

// Text
    textPrimary = black000,
    textSecondary = gray900,
    textTertiary = gray600,
    textDisabled = gray500,
    textBright = white000,
    textPointed = pointColor400,
    textWarned = warningRed400,

// Dim
    dimNormal = gray900A30,
    dimThick = gray900A70,
    dimThickBright = white000A70,

// Border
    borderThin = gray100,
    borderNormal = black000A10,
    borderThick = gray500,

// Button
    buttonNormal = gray700,
    buttonNormalPressed = gray600,
    buttonBG = gray200,
    buttonEmojiBG = gray100,
    buttonBright = white000,
    buttonDisabled = gray500,
    buttonDisabledBG = gray200,
    buttonPoint = pointColor400,
    buttonPointPressed = pointColor300,
    buttonPointBG = pointColor050,
    buttonWarned = warningRed400,
    buttonWarnedPressed = warningRed300,
    buttonWarnedBG = warningRed050,

// BottomBar
    bottomBarNormal = gray600,
    bottomBarSelected = gray800,

// InputField
    inputFieldNormal = white000,
    inputFieldElevated = gray100,

// Toast
    toastBG = gray800,

// Tooltip
    tooltipBG = gray700,
    tooltipPoint = pointColor400,

// Pressed
    pressed = black000A10,

// Shadow
    shadowThin = gray400,
    shadowNormal = gray500,

// MonoItem
    monoItemPrimary = gray700,
    monoItemBG = gray100,
    monoItemText = gray800,

// LimeTag
    limeItemPrimary = lime300,
    limeItemBG = lime050,
//    val limeItemText = ???

// GreenItem
    greenItemPrimary = green300,
    greenItemBG = green050,
    greenItemText = green800,

// EmeraldItem
    emeraldItemPrimary = emerald300,
    emeraldItemBG = emerald050,
    emeraldItemText = emerald800,

// AquaItem
    aquaItemPrimary = aqua300,
    aquaItemBG = aqua050,
    aquaItemText = aqua700,

// BlueItem
    blueItemPrimary = blue300,
    blueItemBG = blue050,
    blueItemText = blue700,

// IndigoItem
    indigoItemPrimary = indigo300,
    indigoItemBG = indigo050,
    indigoItemText = indigo400,

// VioletItem
    violetItemPrimary = violet300,
    violetItemBG = violet050,
    violetItemText = violet400,

// PurpleItem
    purpleItemPrimary = purple300,
    purpleItemBG = purple050,
    purpleItemText = purple400,

// PinkItem
    pinkItemPrimary = pink300,
    pinkItemBG = pink050,
    pinkItemText = pink600,
)

val darkThemeColors = ColorScheme(
    // Background
    bgNormal = black000,
    bgElevated = black000,
    bgRecomment = realBlack,
    bgSelected = gray900,
    bgPressed = gray800,
    bgNormalDark = realBlack,
    bgElevatedDark = realBlack,

// Text
    textPrimary = gray100,
    textSecondary = gray200,
    textTertiary = gray600,
    textDisabled = gray700,
    textBright = white000,
    textPointed = pointColor300,
    textWarned = warningRed300,

// Dim
    dimNormal = gray900A30,
    dimThick = gray900A70,
    dimThickBright = white000A70,

// Border
    borderThin = gray900,
    borderNormal = white000A10,
    borderThick = gray500,

// Button
    buttonNormal = gray300,
    buttonNormalPressed = gray200,
    buttonBG = gray800,
    buttonEmojiBG = gray900,
    buttonBright = white000,
    buttonDisabled = gray600,
    buttonDisabledBG = gray800,
    buttonPoint = pointColor400,
    buttonPointPressed = pointColor300,
    buttonPointBG = pointColor050,
    buttonWarned = warningRed400,
    buttonWarnedPressed = warningRed300,
    buttonWarnedBG = warningRed050,

// BottomBar
    bottomBarNormal = gray600,
    bottomBarSelected = gray200,

// InputField
    inputFieldNormal = black000,
    inputFieldElevated = gray900,

// Toast
    toastBG = gray800,

// Tooltip
    tooltipBG = gray700,
    tooltipPoint = pointColor400,

// Pressed
    pressed = black000A10,

// Shadow
    shadowThin = Color.Transparent,
    shadowNormal = Color.Transparent,

// MonoItem
    monoItemPrimary = gray700,
    monoItemBG = gray100,
    monoItemText = gray800,

// LimeTag
    limeItemPrimary = lime300,
    limeItemBG = lime050,
//    limeItemText = ???

// GreenItem
    greenItemPrimary = green300,
    greenItemBG = green050,
    greenItemText = green800,

// EmeraldItem
    emeraldItemPrimary = emerald300,
    emeraldItemBG = emerald050,
    emeraldItemText = emerald800,

// AquaItem
    aquaItemPrimary = aqua300,
    aquaItemBG = aqua050,
    aquaItemText = aqua700,

// BlueItem
    blueItemPrimary = blue300,
    blueItemBG = blue050,
    blueItemText = blue700,

// IndigoItem
    indigoItemPrimary = indigo300,
    indigoItemBG = indigo050,
    indigoItemText = indigo400,

// VioletItem
    violetItemPrimary = violet300,
    violetItemBG = violet050,
    violetItemText = violet400,

// PurpleItem
    purpleItemPrimary = purple300,
    purpleItemBG = purple050,
    purpleItemText = purple400,

// PinkItem
    pinkItemPrimary = pink300,
    pinkItemBG = pink050,
    pinkItemText = pink600,
)

internal val LocalColors = staticCompositionLocalOf {
    lightThemeColors
}
