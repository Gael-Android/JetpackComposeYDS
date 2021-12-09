package com.eggtart.jetpackcomposeyds.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalColors = staticCompositionLocalOf { YdsColors() }

class YdsColors(
    bgNormal: Color = BgNormal,
    bgElevated: Color = BgElevated,
    bgRecomment: Color = BgRecomment,
    bgSelected: Color = BgSelected,
    bgPressed: Color = BgPressed,
    bgNormalReversed: Color = BgNormalReversed,
    bgElevatedReversed: Color = BgElevatedReversed,
    textPrimary: Color = TextPrimary,
    textSecondary: Color = TextSecondary,
    textTertiary: Color = TextTertiary,
    textDisabled: Color = TextDisabled,
    textReversed: Color = TextReversed,
    textPointed: Color = TextPointed,
    textWarned: Color = TextWarned,
    dimNormal: Color = DimNormal,
    dimThick: Color = DimThick,
    dimThickReversed: Color = DimThickReversed,
    borderThin: Color = BorderThin,
    borderNormal: Color = BorderNormal,
    borderThick: Color = BorderThick,
    buttonNormal: Color = ButtonNormal,
    buttonNormalPressed: Color = ButtonNormalPressed,
    buttonBG: Color = ButtonBG,
    buttonEmojiBG: Color = ButtonEmojiBG,
    buttonReversed: Color = ButtonReversed,
    buttonDisabled: Color = ButtonDisabled,
    buttonDisabledBG: Color = ButtonDisabledBG,
    buttonPoint: Color = ButtonPoint,
    buttonPointPressed: Color = ButtonPointPressed,
    buttonPointBG: Color = ButtonPointBG,
    buttonWarned: Color = ButtonWarned,
    buttonWarnedPressed: Color = ButtonWarnedPressed,
    buttonWarnedBG: Color = ButtonWarnedBG,
    bottomBarNormal: Color = BottomBarNormal,
    bottomBarSelected: Color = BottomBarSelected,
    inputFieldNormal: Color = InputFieldNormal,
    inputFieldElevated: Color = InputFieldElevated,
    toastBG: Color = ToastBG,
    pressed: Color = Pressed,
    shadowThin: Color = ShadowThin,
    shadowNormal: Color = ShadowNormal,
    monoItemPrimary: Color = MonoItemPrimary,
    monoItemBG: Color = MonoItemBG,
    monoItemText: Color = MonoItemText,
    greenItemPrimary: Color = GreenItemPrimary,
    greenItemBG: Color = GreenItemBG,
    greenItemText: Color = GreenItemText,
    emeraldItemPrimary: Color = EmeraldItemPrimary,
    emeraldItemBG: Color = EmeraldItemBG,
    emeraldItemText: Color = EmeraldItemText,
    aquaItemPrimary: Color = AquaItemPrimary,
    aquaItemBG: Color = AquaItemBG,
    aquaItemText: Color = AquaItemText,
    blueItemPrimary: Color = BlueItemPrimary,
    blueItemBG: Color = BlueItemBG,
    blueItemText: Color = BlueItemText,
    indigoItemPrimary: Color = IndigoItemPrimary,
    indigoItemBG: Color = IndigoItemBG,
    indigoItemText: Color = IndigoItemText,
    violetItemPrimary: Color = VioletItemPrimary,
    violetItemBG: Color = VioletItemBG,
    violetItemText: Color = VioletItemText,
    purpleItemPrimary: Color = PurpleItemPrimary,
    purpleItemBG: Color = PurpleItemBG,
    purpleItemText: Color = PurpleItemText,
    pinkItemPrimary: Color = PinkItemPrimary,
    pinkItemBG: Color = PinkItemBG,
    pinkItemText: Color = PinkItemText,
) {
    var bgNormal by mutableStateOf(bgNormal)
        internal set
    var bgElevated by mutableStateOf(bgElevated)
        internal set
    var bgRecomment by mutableStateOf(bgRecomment)
        internal set
    var bgSelected by mutableStateOf(bgSelected)
        internal set
    var bgPressed by mutableStateOf(bgPressed)
        internal set
    var bgNormalReversed by mutableStateOf(bgNormalReversed)
        internal set
    var bgElevatedReversed by mutableStateOf(bgElevatedReversed)
        internal set
    var textPrimary by mutableStateOf(textPrimary)
        internal set
    var textSecondary by mutableStateOf(textSecondary)
        internal set
    var textTertiary by mutableStateOf(textTertiary)
        internal set
    var textDisabled by mutableStateOf(textDisabled)
        internal set
    var textReversed by mutableStateOf(textReversed)
        internal set
    var textPointed by mutableStateOf(textPointed)
        internal set
    var textWarned by mutableStateOf(textWarned)
        internal set
    var dimNormal by mutableStateOf(dimNormal)
        internal set
    var dimThick by mutableStateOf(dimThick)
        internal set
    var dimThickReversed by mutableStateOf(dimThickReversed)
        internal set
    var borderThin by mutableStateOf(borderThin)
        internal set
    var borderNormal by mutableStateOf(borderNormal)
        internal set
    var borderThick by mutableStateOf(borderThick)
        internal set
    var buttonNormal by mutableStateOf(buttonNormal)
        internal set
    var buttonNormalPressed by mutableStateOf(buttonNormalPressed)
        internal set
    var buttonBG by mutableStateOf(buttonBG)
        internal set
    var buttonEmojiBG by mutableStateOf(buttonEmojiBG)
        internal set
    var buttonReversed by mutableStateOf(buttonReversed)
        internal set
    var buttonDisabled by mutableStateOf(buttonDisabled)
        internal set
    var buttonDisabledBG by mutableStateOf(buttonDisabledBG)
        internal set
    var buttonPoint by mutableStateOf(buttonPoint)
        internal set
    var buttonPointPressed by mutableStateOf(buttonPointPressed)
        internal set
    var buttonPointBG by mutableStateOf(buttonPointBG)
        internal set
    var buttonWarned by mutableStateOf(buttonWarned)
        internal set
    var buttonWarnedPressed by mutableStateOf(buttonWarnedPressed)
        internal set
    var buttonWarnedBG by mutableStateOf(buttonWarnedBG)
        internal set
    var bottomBarNormal by mutableStateOf(bottomBarNormal)
        internal set
    var bottomBarSelected by mutableStateOf(bottomBarSelected)
        internal set
    var inputFieldNormal by mutableStateOf(inputFieldNormal)
        internal set
    var inputFieldElevated by mutableStateOf(inputFieldElevated)
        internal set
    var toastBG by mutableStateOf(toastBG)
        internal set
    var pressed by mutableStateOf(pressed)
        internal set
    var shadowThin by mutableStateOf(shadowThin)
        internal set
    var shadowNormal by mutableStateOf(shadowNormal)
        internal set
    var monoItemPrimary by mutableStateOf(monoItemPrimary)
        internal set
    var monoItemBG by mutableStateOf(monoItemBG)
        internal set
    var monoItemText by mutableStateOf(monoItemText)
        internal set
    var greenItemPrimary by mutableStateOf(greenItemPrimary)
        internal set
    var greenItemBG by mutableStateOf(greenItemBG)
        internal set
    var greenItemText by mutableStateOf(greenItemText)
        internal set
    var emeraldItemPrimary by mutableStateOf(emeraldItemPrimary)
        internal set
    var emeraldItemBG by mutableStateOf(emeraldItemBG)
        internal set
    var emeraldItemText by mutableStateOf(emeraldItemText)
        internal set
    var aquaItemPrimary by mutableStateOf(aquaItemPrimary)
        internal set
    var aquaItemBG by mutableStateOf(aquaItemBG)
        internal set
    var aquaItemText by mutableStateOf(aquaItemText)
        internal set
    var blueItemPrimary by mutableStateOf(blueItemPrimary)
        internal set
    var blueItemBG by mutableStateOf(blueItemBG)
        internal set
    var blueItemText by mutableStateOf(blueItemText)
        internal set
    var indigoItemPrimary by mutableStateOf(indigoItemPrimary)
        internal set
    var indigoItemBG by mutableStateOf(indigoItemBG)
        internal set
    var indigoItemText by mutableStateOf(indigoItemText)
        internal set
    var violetItemPrimary by mutableStateOf(violetItemPrimary)
        internal set
    var violetItemBG by mutableStateOf(violetItemBG)
        internal set
    var violetItemText by mutableStateOf(violetItemText)
        internal set
    var purpleItemPrimary by mutableStateOf(purpleItemPrimary)
        internal set
    var purpleItemBG by mutableStateOf(purpleItemBG)
        internal set
    var purpleItemText by mutableStateOf(purpleItemText)
        internal set
    var pinkItemPrimary by mutableStateOf(pinkItemPrimary)
        internal set
    var pinkItemBG by mutableStateOf(pinkItemBG)
        internal set
    var pinkItemText by mutableStateOf(pinkItemText)
        internal set

    fun copy(
        bgNormal: Color = this.bgNormal,
        bgElevated: Color = this.bgElevated,
        bgRecomment: Color = this.bgRecomment,
        bgSelected: Color = this.bgSelected,
        bgPressed: Color = this.bgPressed,
        bgNormalReversed: Color = this.bgNormalReversed,
        bgElevatedReversed: Color = this.bgElevatedReversed,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        textTertiary: Color = this.textTertiary,
        textDisabled: Color = this.textDisabled,
        textReversed: Color = this.textReversed,
        textPointed: Color = this.textPointed,
        textWarned: Color = this.textWarned,
        dimNormal: Color = this.dimNormal,
        dimThick: Color = this.dimThick,
        dimThickReversed: Color = this.dimThickReversed,
        borderThin: Color = this.borderThin,
        borderNormal: Color = this.borderNormal,
        borderThick: Color = this.borderThick,
        buttonNormal: Color = this.buttonNormal,
        buttonNormalPressed: Color = this.buttonNormalPressed,
        buttonBG: Color = this.buttonBG,
        buttonEmojiBG: Color = this.buttonEmojiBG,
        buttonReversed: Color = this.buttonReversed,
        buttonDisabled: Color = this.buttonDisabled,
        buttonDisabledBG: Color = this.buttonDisabledBG,
        buttonPoint: Color = this.buttonPoint,
        buttonPointPressed: Color = this.buttonPointPressed,
        buttonPointBG: Color = this.buttonPointBG,
        buttonWarned: Color = this.buttonWarned,
        buttonWarnedPressed: Color = this.buttonWarnedPressed,
        buttonWarnedBG: Color = this.buttonWarnedBG,
        bottomBarNormal: Color = this.bottomBarNormal,
        bottomBarSelected: Color = this.bottomBarSelected,
        inputFieldNormal: Color = this.inputFieldNormal,
        inputFieldElevated: Color = this.inputFieldElevated,
        toastBG: Color = this.toastBG,
        pressed: Color = this.pressed,
        shadowThin: Color = this.shadowThin,
        shadowNormal: Color = this.shadowNormal,
        monoItemPrimary: Color = this.monoItemPrimary,
        monoItemBG: Color = this.monoItemBG,
        monoItemText: Color = this.monoItemText,
        greenItemPrimary: Color = this.greenItemPrimary,
        greenItemBG: Color = this.greenItemBG,
        greenItemText: Color = this.greenItemText,
        emeraldItemPrimary: Color = this.emeraldItemPrimary,
        emeraldItemBG: Color = this.emeraldItemBG,
        emeraldItemText: Color = this.emeraldItemText,
        aquaItemPrimary: Color = this.aquaItemPrimary,
        aquaItemBG: Color = this.aquaItemBG,
        aquaItemText: Color = this.aquaItemText,
        blueItemPrimary: Color = this.blueItemPrimary,
        blueItemBG: Color = this.blueItemBG,
        blueItemText: Color = this.blueItemText,
        indigoItemPrimary: Color = this.indigoItemPrimary,
        indigoItemBG: Color = this.indigoItemBG,
        indigoItemText: Color = this.indigoItemText,
        violetItemPrimary: Color = this.violetItemPrimary,
        violetItemBG: Color = this.violetItemBG,
        violetItemText: Color = this.violetItemText,
        purpleItemPrimary: Color = this.purpleItemPrimary,
        purpleItemBG: Color = this.purpleItemBG,
        purpleItemText: Color = this.purpleItemText,
        pinkItemPrimary: Color = this.pinkItemPrimary,
        pinkItemBG: Color = this.pinkItemBG,
        pinkItemText: Color = this.pinkItemText,
    ): YdsColors = YdsColors(
        bgNormal,
        bgElevated,
        bgRecomment,
        bgSelected,
        bgPressed,
        bgNormalReversed,
        bgElevatedReversed,
        textPrimary,
        textSecondary,
        textTertiary,
        textDisabled,
        textReversed,
        textPointed,
        textWarned,
        dimNormal,
        dimThick,
        dimThickReversed,
        borderThin,
        borderNormal,
        borderThick,
        buttonNormal,
        buttonNormalPressed,
        buttonBG,
        buttonEmojiBG,
        buttonReversed,
        buttonDisabled,
        buttonDisabledBG,
        buttonPoint,
        buttonPointPressed,
        buttonPointBG,
        buttonWarned,
        buttonWarnedPressed,
        buttonWarnedBG,
        bottomBarNormal,
        bottomBarSelected,
        inputFieldNormal,
        inputFieldElevated,
        toastBG,
        pressed,
        shadowThin,
        shadowNormal,
        monoItemPrimary,
        monoItemBG,
        monoItemText,
        greenItemPrimary,
        greenItemBG,
        greenItemText,
        emeraldItemPrimary,
        emeraldItemBG,
        emeraldItemText,
        aquaItemPrimary,
        aquaItemBG,
        aquaItemText,
        blueItemPrimary,
        blueItemBG,
        blueItemText,
        indigoItemPrimary,
        indigoItemBG,
        indigoItemText,
        violetItemPrimary,
        violetItemBG,
        violetItemText,
        purpleItemPrimary,
        purpleItemBG,
        purpleItemText,
        pinkItemPrimary,
        pinkItemBG,
        pinkItemText,
    )

    fun updateColorsFrom(other: YdsColors) {
        bgNormal = other.bgNormal
        bgElevated = other.bgElevated
        bgRecomment = other.bgRecomment
        bgSelected = other.bgSelected
        bgPressed = other.bgPressed
        bgNormalReversed = other.bgNormalReversed
        bgElevatedReversed = other.bgElevatedReversed
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textTertiary = other.textTertiary
        textDisabled = other.textDisabled
        textReversed = other.textReversed
        textPointed = other.textPointed
        textWarned = other.textWarned
        dimNormal = other.dimNormal
        dimThick = other.dimThick
        dimThickReversed = other.dimThickReversed
        borderThin = other.borderThin
        borderNormal = other.borderNormal
        borderThick = other.borderThick
        buttonNormal = other.buttonNormal
        buttonNormalPressed = other.buttonNormalPressed
        buttonBG = other.buttonBG
        buttonEmojiBG = other.buttonEmojiBG
        buttonReversed = other.buttonReversed
        buttonDisabled = other.buttonDisabled
        buttonDisabledBG = other.buttonDisabledBG
        buttonPoint = other.buttonPoint
        buttonPointPressed = other.buttonPointPressed
        buttonPointBG = other.buttonPointBG
        buttonWarned = other.buttonWarned
        buttonWarnedPressed = other.buttonWarnedPressed
        buttonWarnedBG = other.buttonWarnedBG
        bottomBarNormal = other.bottomBarNormal
        bottomBarSelected = other.bottomBarSelected
        inputFieldNormal = other.inputFieldNormal
        inputFieldElevated = other.inputFieldElevated
        toastBG = other.toastBG
        pressed = other.pressed
        shadowThin = other.shadowThin
        shadowNormal = other.shadowNormal
        monoItemPrimary = other.monoItemPrimary
        monoItemBG = other.monoItemBG
        monoItemText = other.monoItemText
        greenItemPrimary = other.greenItemPrimary
        greenItemBG = other.greenItemBG
        greenItemText = other.greenItemText
        emeraldItemPrimary = other.emeraldItemPrimary
        emeraldItemBG = other.emeraldItemBG
        emeraldItemText = other.emeraldItemText
        aquaItemPrimary = other.aquaItemPrimary
        aquaItemBG = other.aquaItemBG
        aquaItemText = other.aquaItemText
        blueItemPrimary = other.blueItemPrimary
        blueItemBG = other.blueItemBG
        blueItemText = other.blueItemText
        indigoItemPrimary = other.indigoItemPrimary
        indigoItemBG = other.indigoItemBG
        indigoItemText = other.indigoItemText
        violetItemPrimary = other.violetItemPrimary
        violetItemBG = other.violetItemBG
        violetItemText = other.violetItemText
        purpleItemPrimary = other.purpleItemPrimary
        purpleItemBG = other.purpleItemBG
        purpleItemText = other.purpleItemText
        pinkItemPrimary = other.pinkItemPrimary
        pinkItemBG = other.pinkItemBG
        pinkItemText = other.pinkItemText
    }
}