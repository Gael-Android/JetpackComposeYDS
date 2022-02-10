package com.eggtart.jetpackcomposeyds.ui.theme.atom

import android.view.MotionEvent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.LocalColors
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon

private enum class PlainButtonState {
    IS_NOT_POINTED,
    IS_POINTED,
    IS_DISABLED,
    IS_WARNED,
}

enum class PlainButtonSize {
    LARGE,
    MEDIUM,
    SMALL,
}

private data class PlainButtonContentData(
    val typo: TextStyle,
    val iconSize: IconSize,
)

private enum class PlainButtonPressed {
    PRESSED,
    UP,
}

@ExperimentalComposeUiApi
@Composable
fun PlainButton(
    text: String = "",
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    isDisabled: Boolean = false,
    isWarned: Boolean = false,
    isPointed: Boolean = false,
    size: PlainButtonSize = PlainButtonSize.LARGE,
) {
    var isPressed by remember {
        mutableStateOf(PlainButtonPressed.UP)
    }

    val plainButtonState =
        if (isDisabled) {
            PlainButtonState.IS_DISABLED
        } else {
            if (isWarned) {
                PlainButtonState.IS_WARNED
            } else {
                if (isPointed) {
                    PlainButtonState.IS_POINTED
                } else {
                    PlainButtonState.IS_NOT_POINTED
                }
            }
        }

    val plainButtonContentData = when (size) {
        PlainButtonSize.LARGE -> {
            PlainButtonContentData(
                typo = YdsTheme.typography.Button3, // 없어야 하는데...
                iconSize = IconSize.Medium
            )
        }
        PlainButtonSize.MEDIUM -> {
            PlainButtonContentData(
                typo = YdsTheme.typography.Button3,
                iconSize = IconSize.Small
            )
        }
        PlainButtonSize.SMALL -> {
            PlainButtonContentData(
                typo = YdsTheme.typography.Button4,
                iconSize = IconSize.ExtraSmall
            )
        }
    }

    val buttonColors = when (plainButtonState) {
        PlainButtonState.IS_NOT_POINTED -> {
            if (isPressed == PlainButtonPressed.UP) {
                textButtonColors(
                    contentColor = YdsTheme.colors.buttonNormal
                )
            } else {
                textButtonColors(
                    contentColor = YdsTheme.colors.buttonNormalPressed
                )
            }
        }
        PlainButtonState.IS_POINTED -> {
            if (isPressed == PlainButtonPressed.UP) {
                textButtonColors(
                    contentColor = YdsTheme.colors.buttonPoint
                )
            } else {
                textButtonColors(
                    contentColor = YdsTheme.colors.buttonPointPressed
                )
            }
        }
        PlainButtonState.IS_DISABLED -> {
            textButtonColors(
                contentColor = YdsTheme.colors.buttonDisabled
            )
        }
        PlainButtonState.IS_WARNED -> {
            if (isPressed == PlainButtonPressed.UP) {
                textButtonColors(
                    contentColor = YdsTheme.colors.buttonWarned
                )
            } else {
                textButtonColors(
                    contentColor = YdsTheme.colors.buttonWarnedPressed
                )
            }
        }
    }

    TextButton(
        onClick = {
            /*TODO*/
        },
        enabled = plainButtonState != PlainButtonState.IS_DISABLED,
        modifier = Modifier
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        isPressed = PlainButtonPressed.PRESSED
                    }
                    MotionEvent.ACTION_UP -> {
                        isPressed = PlainButtonPressed.UP
                    }
                }
                true
            },
        colors = buttonColors,
    ) {
        if (leftIcon != null) {
            YdsIcon(
                id = leftIcon,
                iconSize = plainButtonContentData.iconSize,
                tint = buttonColors.contentColor(
                    enabled = (plainButtonState != PlainButtonState.IS_DISABLED)
                ).value,
            )
            Spacer(
                modifier = Modifier.padding(
                    end = 2.dp
                )
            )
        }
        if (size != PlainButtonSize.LARGE) {
            Text(
                text = text,
                style = plainButtonContentData.typo
            )
        }
        if (leftIcon == null && rightIcon != null) {
            Spacer(
                modifier = Modifier.padding(
                    end = 2.dp
                )
            )
            YdsIcon(
                id = rightIcon,
                iconSize = plainButtonContentData.iconSize,
                tint = buttonColors.contentColor(
                    enabled = (plainButtonState != PlainButtonState.IS_DISABLED)
                ).value,
            )
        }
    }
}

@ExperimentalComposeUiApi
@Preview(
    showSystemUi = true,
)
@Composable
fun PreviewPlainButton() {
    JetpackComposeYDSTheme {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            for (isDisabled in listOf(true, false)) {
                for (isWarned in listOf(true, false)) {
                    for (isPointed in listOf(true, false)) {
                        PlainButton(
                            text = "PreviewPlainButton",
                            leftIcon = R.drawable.ic_ground_line,
                            rightIcon = null,
                            isDisabled = isDisabled,
                            isWarned = isWarned,
                            isPointed = isPointed,
                            size = PlainButtonSize.SMALL
                        )
                    }
                }
            }
        }
    }
}