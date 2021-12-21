package com.eggtart.jetpackcomposeyds.ui.theme.atom

import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.ButtonDefaults.outlinedButtonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon


enum class Type {
    FILLED, // 가장 중요한 버튼에 사용합니다. 남용을 지양해주세요.
    TINTED, // 어중간하게 중요한 버튼에 사용합니다.
    LINE, // 덜 중요한 버튼에 사용합니다.
}

enum class Size {
    EXTRA_LARGE, // 화면에서 단 하나의 버튼을 강조할 때 사용합니다.
    LARGE,
    MEDIUM,
    SMALL,
}

enum class Rounding(val dp: Dp) {
    FOUR(4.dp),
    EIGHT(8.dp),
}

enum class ButtonState {
    IS_DISABLED,
    IS_ENABLED,
    IS_WARNED,
}

data class BoxButtonContentData(
    val height: Dp,
    val typo: TextStyle,
    val iconSize: IconSize,
    val horizontalPadding: Dp,
)

enum class ButtonPressState {
    UP,
    DOWN
}


@ExperimentalComposeUiApi
@Composable
fun BoxButton(
    text: String = "",
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    type: Type = Type.FILLED,
    isDisabled: Boolean = false,
    isWarned: Boolean = false,
    size: Size = Size.EXTRA_LARGE,
    rounding: Rounding = Rounding.EIGHT,
) {
    var isPressed by remember { mutableStateOf(ButtonPressState.UP) }

    val boxButtonContentData = when (size) {
        Size.EXTRA_LARGE -> {
            BoxButtonContentData(
                height = 56.dp,
                typo = YdsTheme.typography.Button1,
                iconSize = IconSize.MEDIUM,
                horizontalPadding = 16.dp,
            )
        }
        Size.LARGE -> {
            BoxButtonContentData(
                height = 48.dp,
                typo = YdsTheme.typography.Button2,
                iconSize = IconSize.MEDIUM,
                horizontalPadding = 16.dp,
            )
        }
        Size.MEDIUM -> {
            BoxButtonContentData(
                height = 40.dp,
                typo = YdsTheme.typography.Button2,
                iconSize = IconSize.MEDIUM,
                horizontalPadding = 12.dp,
            )
        }
        Size.SMALL -> {
            BoxButtonContentData(
                height = 32.dp,
                typo = YdsTheme.typography.Button4,
                iconSize = IconSize.SMALL,
                horizontalPadding = 12.dp,
            )
        }
    }


    val buttonState = if (isWarned) {
        ButtonState.IS_WARNED
    } else {
        if (isDisabled) {
            ButtonState.IS_DISABLED
        } else {
            ButtonState.IS_ENABLED
        }
    }


    val buttonColors = when (type) {
        Type.FILLED -> {
            when (buttonState) {
                ButtonState.IS_ENABLED -> {
                    if (isPressed == ButtonPressState.UP) {
                        Log.d("KWK_", "not pressed")
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonPoint,
                            contentColor = YdsTheme.colors.buttonReversed,
                            disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                            disabledContentColor = YdsTheme.colors.buttonDisabled,
                        )
                    } else {
                        Log.d("KWK_", "pressed")
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonPointPressed,
                            contentColor = YdsTheme.colors.buttonReversed,
                            disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                            disabledContentColor = YdsTheme.colors.buttonDisabled,
                        )
                    }
                }
                ButtonState.IS_DISABLED -> {
                    buttonColors(
                        backgroundColor = YdsTheme.colors.buttonPoint,
                        contentColor = YdsTheme.colors.buttonReversed,
                        disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                        disabledContentColor = YdsTheme.colors.buttonDisabled,
                    )
                }
                ButtonState.IS_WARNED -> {
                    if (isPressed == ButtonPressState.UP) {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonWarned,
                            contentColor = YdsTheme.colors.buttonReversed,
                            disabledBackgroundColor = YdsTheme.colors.buttonWarned,
                            disabledContentColor = YdsTheme.colors.buttonReversed,
                        )
                    } else {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonWarnedPressed,
                            contentColor = YdsTheme.colors.buttonReversed,
                            disabledBackgroundColor = YdsTheme.colors.buttonWarnedPressed,
                            disabledContentColor = YdsTheme.colors.buttonReversed,
                        )
                    }
                }
            }
        }
        Type.TINTED -> {
            when (buttonState) {
                ButtonState.IS_ENABLED -> {
                    if (isPressed == ButtonPressState.UP) {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonPointBG,
                            contentColor = YdsTheme.colors.buttonPoint,
                            disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                            disabledContentColor = YdsTheme.colors.buttonDisabled,
                        )
                    } else {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonPointBG,
                            contentColor = YdsTheme.colors.buttonPointPressed,
                            disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                            disabledContentColor = YdsTheme.colors.buttonDisabled,
                        )
                    }
                }
                ButtonState.IS_DISABLED -> {
                    buttonColors(
                        backgroundColor = YdsTheme.colors.buttonDisabledBG,
                        contentColor = YdsTheme.colors.buttonDisabled,
                        disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                        disabledContentColor = YdsTheme.colors.buttonDisabled,
                    )
                }
                ButtonState.IS_WARNED -> {
                    if (isPressed == ButtonPressState.UP) {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonWarnedBG,
                            contentColor = YdsTheme.colors.buttonWarned,
                            disabledBackgroundColor = YdsTheme.colors.buttonWarnedBG,
                            disabledContentColor = YdsTheme.colors.buttonWarned,
                        )
                    } else {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonWarnedBG,
                            contentColor = YdsTheme.colors.buttonWarnedPressed,
                            disabledBackgroundColor = YdsTheme.colors.buttonWarnedBG,
                            disabledContentColor = YdsTheme.colors.buttonWarnedPressed,
                        )
                    }
                }
            }
        }
        Type.LINE -> {
            when (buttonState) {
                ButtonState.IS_ENABLED -> {
                    if (isPressed == ButtonPressState.UP) {
                        outlinedButtonColors(
                            backgroundColor = YdsTheme.colors.bgNormal,
                            contentColor = YdsTheme.colors.buttonPoint,
                            disabledContentColor = YdsTheme.colors.buttonPoint
                        )
                    } else {
                        outlinedButtonColors(
                            backgroundColor = YdsTheme.colors.bgNormal,
                            contentColor = YdsTheme.colors.buttonPointPressed,
                            disabledContentColor = YdsTheme.colors.buttonPointPressed
                        )
                    }
                }
                ButtonState.IS_DISABLED -> {
                    outlinedButtonColors(
                        backgroundColor = YdsTheme.colors.bgNormal,
                        contentColor = YdsTheme.colors.buttonDisabled,
                        disabledContentColor = YdsTheme.colors.buttonDisabled
                    )
                }
                ButtonState.IS_WARNED -> {
                    if (isPressed == ButtonPressState.UP) {
                        outlinedButtonColors(
                            backgroundColor = YdsTheme.colors.bgNormal,
                            contentColor = YdsTheme.colors.buttonWarned,
                            disabledContentColor = YdsTheme.colors.buttonWarned
                        )
                    } else {
                        outlinedButtonColors(
                            backgroundColor = YdsTheme.colors.bgNormal,
                            contentColor = YdsTheme.colors.buttonWarnedPressed,
                            disabledContentColor = YdsTheme.colors.buttonWarnedPressed
                        )
                    }
                }
            }
        }
    }

    Button(
        onClick = {},
        modifier = Modifier
            .height(boxButtonContentData.height)
            .padding(horizontal = boxButtonContentData.horizontalPadding)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        isPressed = ButtonPressState.DOWN
                    }
                    MotionEvent.ACTION_UP -> {
                        isPressed = ButtonPressState.UP
                    }
                }
                true
            },
        enabled = buttonState != ButtonState.IS_DISABLED,
        elevation = elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        colors = buttonColors,
        border = BorderStroke(
            1.dp,
            buttonColors.contentColor(enabled = buttonState != ButtonState.IS_DISABLED)
                .value
        ),
        shape = RoundedCornerShape(rounding.dp),
    ) {
        if (leftIcon != null) {
            YdsIcon(
                id = leftIcon,
                iconSize = boxButtonContentData.iconSize,
                tint = buttonColors.contentColor(
                    enabled = (buttonState == ButtonState.IS_ENABLED)
                ).value,
            )
            Spacer(
                modifier = Modifier.padding(
                    end = 4.dp
                )
            )
        }
        Text(
            text = text,
            style = boxButtonContentData.typo
        )
        if (leftIcon == null && rightIcon != null) {
            Spacer(
                modifier = Modifier.padding(
                    end = 4.dp
                )
            )
            YdsIcon(
                id = rightIcon,
                iconSize = boxButtonContentData.iconSize,
                tint = buttonColors.contentColor(
                    enabled = (buttonState == ButtonState.IS_ENABLED)
                ).value,
            )
        }
    }

}

@ExperimentalComposeUiApi
@Preview(
    name = "PreviewBoxButton",
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun PreviewBoxButton() {
    val type = Type.LINE
    val isDisabled = false
    val isWarned = false


    JetpackComposeYDSTheme {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            BoxButton(
                text = "what a nice world!",
                leftIcon = R.drawable.ic_ground_line,
                rightIcon = R.drawable.ic_ground_line,
                type = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                size = Size.EXTRA_LARGE,
                rounding = Rounding.EIGHT
            )
            BoxButton(
                text = "what a nice world!",
                leftIcon = R.drawable.ic_ground_line,
                rightIcon = R.drawable.ic_ground_line,
                type = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                size = Size.LARGE,
                rounding = Rounding.EIGHT
            )
            BoxButton(
                text = "what a nice world!",
                leftIcon = R.drawable.ic_ground_line,
                rightIcon = R.drawable.ic_ground_line,
                type = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                size = Size.MEDIUM,
                rounding = Rounding.EIGHT
            )
            BoxButton(
                text = "what a nice world!",
                leftIcon = R.drawable.ic_ground_line,
                rightIcon = R.drawable.ic_ground_line,
                type = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                size = Size.SMALL,
                rounding = Rounding.EIGHT
            )
        }
    }
}

