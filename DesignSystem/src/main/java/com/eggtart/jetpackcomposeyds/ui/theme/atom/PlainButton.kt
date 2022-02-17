package com.eggtart.jetpackcomposeyds.ui.theme.atom

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon

data class PlainButtonState(
    val text: String = "",
    @DrawableRes val leftIcon: Int? = null,
    @DrawableRes val rightIcon: Int? = null,
    val buttonState: ButtonState = ButtonState.NotPointed,
    val sizeState: SizeState = SizeState.Large,
    val interactionSource: MutableInteractionSource = MutableInteractionSource()
) {
    val isPressed
        @Composable get() = interactionSource.collectIsPressedAsState().value

    val isEnabled = buttonState != ButtonState.Disabled

    sealed class ButtonState {
        object Pointed : ButtonState()
        object NotPointed : ButtonState()
        object Disabled : ButtonState()
        object Warned : ButtonState()
    }

    sealed class SizeState {
        object Large : SizeState()
        object Medium : SizeState()
        object Small : SizeState()
    }

    val typo
        @Composable get() = when (sizeState) {
            SizeState.Large, SizeState.Medium -> YdsTheme.typography.Button3
            SizeState.Small -> YdsTheme.typography.Button4
        }

    val iconSize
        @Composable get() = when (sizeState) {
            SizeState.Large -> IconSize.Medium
            SizeState.Medium -> IconSize.Small
            SizeState.Small -> IconSize.ExtraSmall
        }

    val contentColor
        @Composable get() = when (buttonState) {
            ButtonState.NotPointed -> YdsTheme.colors.buttonNormal.maybePressed()
            ButtonState.Pointed -> YdsTheme.colors.buttonPoint.maybePressed()
            ButtonState.Disabled -> YdsTheme.colors.buttonDisabled
            ButtonState.Warned -> YdsTheme.colors.buttonWarned.maybePressed()
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
fun rememberPlainButtonState(
    text: String = "",
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    buttonState: PlainButtonState.ButtonState = PlainButtonState.ButtonState.NotPointed,
    sizeState: PlainButtonState.SizeState = PlainButtonState.SizeState.Large,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) = remember(text, leftIcon, rightIcon, buttonState, sizeState, interactionSource) {
    mutableStateOf(
        PlainButtonState(
            text,
            leftIcon,
            rightIcon,
            buttonState,
            sizeState,
            interactionSource
        )
    )
}

@ExperimentalComposeUiApi
@Composable
fun PlainButton(
    plainButtonState: PlainButtonState,
    onClick: () -> Unit
) {
    NoRippleTextButton(
        onClick = onClick,
        enabled = plainButtonState.isEnabled,
        colors = textButtonColors(contentColor = plainButtonState.contentColor)
    ) {
        if (plainButtonState.leftIcon != null) {
            YdsIcon(
                id = plainButtonState.leftIcon,
                iconSize = plainButtonState.iconSize,
                tint = plainButtonState.contentColor,
            )
            Spacer(
                modifier = Modifier.padding(
                    end = YdsTheme.spacing.two
                )
            )
        }
        if (plainButtonState.sizeState != PlainButtonState.SizeState.Large) {
            Text(
                text = plainButtonState.text,
                style = plainButtonState.typo
            )
        }
        if (plainButtonState.leftIcon == null && plainButtonState.rightIcon != null) {
            Spacer(
                modifier = Modifier.padding(
                    end = YdsTheme.spacing.two
                )
            )
            YdsIcon(
                id = plainButtonState.rightIcon,
                iconSize = plainButtonState.iconSize,
                tint = plainButtonState.contentColor,
            )
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun PreviewPlainButton() {

    val context = LocalContext.current

    fun onClick() {
        Toast.makeText(
            context,
            "Click!",
            Toast.LENGTH_SHORT
        ).show()
    }

    val state by rememberPlainButtonState(
        text = "어떤 텍스트",
        leftIcon = R.drawable.ic_ground_filled,
        rightIcon = R.drawable.ic_ground_filled,
        buttonState = PlainButtonState.ButtonState.Pointed,
        sizeState = PlainButtonState.SizeState.Medium
    )

    JetpackComposeYDSTheme {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            PlainButton(plainButtonState = state) {
                onClick()
            }
        }
    }
}