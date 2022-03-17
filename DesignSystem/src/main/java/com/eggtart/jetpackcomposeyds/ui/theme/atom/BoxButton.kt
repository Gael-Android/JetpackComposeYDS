package com.eggtart.jetpackcomposeyds.ui.theme.atom

import android.util.Log
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.base.NoRippleButton
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon

data class BoxButtonState(
    val text: String = "",
    @DrawableRes val leftIcon: Int? = null,
    @DrawableRes val rightIcon: Int? = null,
    val typeState: TypeState = TypeState.Filled,
    val buttonState: ButtonState = ButtonState.Enabled,
    val sizeState: SizeState = SizeState.ExtraLarge,
    val roundingState: RoundingState = RoundingState.Eight,
    val interactionSource: MutableInteractionSource = MutableInteractionSource()
) {
    val isPressed
        @Composable get() = interactionSource.collectIsPressedAsState().value

    val isEnabled = buttonState != ButtonState.Disabled
    val isLine = typeState == TypeState.Line
    val rounding = roundingState.value

    val height = when (sizeState) {
        SizeState.ExtraLarge -> 56.dp
        SizeState.Large -> 48.dp
        SizeState.Medium -> 40.dp
        SizeState.Small -> 32.dp
    }

    val typo
        @Composable get() = when (sizeState) {
            SizeState.ExtraLarge -> YdsTheme.typography.Button1
            SizeState.Large, SizeState.Medium -> YdsTheme.typography.Button2
            SizeState.Small -> YdsTheme.typography.Button4
        }

    val iconSize
        get() = when (sizeState) {
            SizeState.ExtraLarge, SizeState.Large, SizeState.Medium -> IconSize.Medium
            SizeState.Small -> IconSize.Small
        }

    val horizontalPadding
        get() = when (sizeState) {
            SizeState.ExtraLarge, SizeState.Large -> 16.dp
            SizeState.Medium, SizeState.Small -> 12.dp
        }

    val backgroundColor
        @Composable get() = when (typeState) {
            TypeState.Filled -> when (buttonState) {
                ButtonState.Enabled -> YdsTheme.colors.buttonPoint.maybePressed()
                ButtonState.Disabled -> YdsTheme.colors.buttonPoint
                ButtonState.Warned -> YdsTheme.colors.buttonWarned.maybePressed()
            }
            TypeState.Tinted -> when (buttonState) {
                ButtonState.Enabled -> YdsTheme.colors.buttonPointBG
                ButtonState.Warned -> YdsTheme.colors.buttonWarnedBG
                ButtonState.Disabled -> YdsTheme.colors.buttonDisabledBG
            }
            TypeState.Line -> YdsTheme.colors.bgNormal
        }

    val contentColor
        @Composable get() = when (typeState) {
            TypeState.Filled -> YdsTheme.colors.buttonReversed
            TypeState.Tinted -> when (buttonState) {
                ButtonState.Enabled -> YdsTheme.colors.buttonPoint.maybePressed()
                ButtonState.Disabled -> YdsTheme.colors.buttonDisabled
                ButtonState.Warned -> YdsTheme.colors.buttonWarned.maybePressed()
            }
            TypeState.Line -> when (buttonState) {
                ButtonState.Enabled -> YdsTheme.colors.buttonPoint.maybePressed()
                ButtonState.Disabled -> YdsTheme.colors.buttonDisabled
                ButtonState.Warned -> YdsTheme.colors.buttonWarned.maybePressed()
            }
        }

    val disabledBackgroundColor
        @Composable get() = when (typeState) {
            TypeState.Filled, TypeState.Tinted -> when (buttonState) {
                ButtonState.Enabled -> YdsTheme.colors.buttonDisabledBG
                ButtonState.Disabled -> YdsTheme.colors.buttonDisabledBG
                ButtonState.Warned -> YdsTheme.colors.buttonWarned.maybePressed()
            }
            TypeState.Line -> YdsTheme.colors.bgNormal
        }

    val disabledContentColor
        @Composable get() = when (typeState) {
            TypeState.Filled -> when (buttonState) {
                ButtonState.Enabled, ButtonState.Disabled -> YdsTheme.colors.buttonDisabled
                ButtonState.Warned -> YdsTheme.colors.buttonReversed
            }
            TypeState.Tinted -> when (buttonState) {
                ButtonState.Enabled, ButtonState.Disabled -> YdsTheme.colors.buttonDisabled
                ButtonState.Warned -> YdsTheme.colors.buttonWarned.maybePressed()
            }
            TypeState.Line -> when (buttonState) {
                ButtonState.Enabled -> YdsTheme.colors.buttonPoint.maybePressed()
                ButtonState.Disabled -> YdsTheme.colors.buttonDisabled
                ButtonState.Warned -> YdsTheme.colors.buttonWarned.maybePressed()
            }
        }

    sealed class TypeState {
        object Filled : TypeState() // 가장 중요한 버튼에 사용합니다. 남용을 지양해주세요.
        object Tinted : TypeState() // 어중간하게 중요한 버튼에 사용합니다.
        object Line : TypeState() // 덜 중요한 버튼에 사용합니다.
    }

    sealed class SizeState {
        object ExtraLarge : SizeState() // 화면에서 단 하나의 버튼을 강조할 때 사용합니다.
        object Large : SizeState()
        object Medium : SizeState()
        object Small : SizeState()
    }

    sealed class RoundingState(val value: Dp) {
        object Four : RoundingState(4.dp)
        object Eight : RoundingState(8.dp)
    }

    sealed class ButtonState {
        object Disabled : ButtonState()
        object Enabled : ButtonState()
        object Warned : ButtonState()
    }

    @Composable
    fun Color.toPressedColor(): Color = when (this) {
        YdsTheme.colors.buttonPoint -> YdsTheme.colors.buttonPointPressed
        YdsTheme.colors.buttonWarned -> YdsTheme.colors.buttonWarnedPressed
        YdsTheme.colors.buttonNormal -> YdsTheme.colors.buttonNormalPressed
        else -> this
    }

    @Composable
    fun Color.maybePressed() =
        if (isPressed) {
            this.toPressedColor()
        } else {
            this
        }
}

@Composable
fun rememberBoxButtonState(
    text: String = "",
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    typeState: BoxButtonState.TypeState = BoxButtonState.TypeState.Filled,
    buttonState: BoxButtonState.ButtonState = BoxButtonState.ButtonState.Enabled,
    sizeState: BoxButtonState.SizeState = BoxButtonState.SizeState.ExtraLarge,
    rounding: BoxButtonState.RoundingState = BoxButtonState.RoundingState.Eight,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) = remember(
    text, leftIcon, rightIcon, typeState, buttonState, sizeState, rounding, interactionSource
) {
    mutableStateOf(
        BoxButtonState(
            text,
            leftIcon,
            rightIcon,
            typeState,
            buttonState,
            sizeState,
            rounding,
            interactionSource
        )
    )
}

@ExperimentalComposeUiApi
@Composable
fun BoxButton(
    boxButtonState: BoxButtonState,
    onClick: () -> Unit
) {
    NoRippleButton(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .height(boxButtonState.height)
            .padding(horizontal = boxButtonState.horizontalPadding),
        enabled = boxButtonState.isEnabled,
        elevation = elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        interactionSource = boxButtonState.interactionSource,
        colors = buttonColors(
            backgroundColor = boxButtonState.backgroundColor,
            contentColor = boxButtonState.contentColor,
            disabledBackgroundColor = boxButtonState.disabledBackgroundColor,
            disabledContentColor = boxButtonState.disabledContentColor
        ),
        border = if (boxButtonState.isLine) {
            BorderStroke(
                1.dp,
                boxButtonState.contentColor
            )
        } else {
            null
        },
        shape = RoundedCornerShape(boxButtonState.rounding),
    ) {
        if (boxButtonState.leftIcon != null) {
            YdsIcon(
                id = boxButtonState.leftIcon,
                iconSize = boxButtonState.iconSize,
                tint = boxButtonState.contentColor
            )
            Spacer(
                modifier = Modifier.padding(
                    end = YdsTheme.spacing.four
                )
            )
        }
        Text(
            text = boxButtonState.text,
            style = boxButtonState.typo
        )
        if (boxButtonState.leftIcon == null && boxButtonState.rightIcon != null) {
            Spacer(
                modifier = Modifier.padding(
                    end = YdsTheme.spacing.four
                )
            )
            YdsIcon(
                id = boxButtonState.rightIcon,
                iconSize = boxButtonState.iconSize,
                tint = boxButtonState.contentColor,
            )
        }
    }

}

@ExperimentalComposeUiApi
@Preview
@Composable
fun PreviewBoxButton() {
    val context = LocalContext.current

    fun onClick() {
        Toast.makeText(
            context,
            "Click!",
            Toast.LENGTH_SHORT
        ).show()
    }

    val state by rememberBoxButtonState(
        text = "재생하기",
        leftIcon = R.drawable.ic_ground_filled,
        rightIcon = R.drawable.ic_ground_filled,
        typeState = BoxButtonState.TypeState.Line,
        buttonState = BoxButtonState.ButtonState.Enabled,
        sizeState = BoxButtonState.SizeState.ExtraLarge,
        rounding = BoxButtonState.RoundingState.Eight,
    )

    JetpackComposeYDSTheme {
        BoxButton(
            boxButtonState = state,
            onClick = {
                onClick()
                Log.d("KWK", "onClick!")
            }
        )
    }
}

