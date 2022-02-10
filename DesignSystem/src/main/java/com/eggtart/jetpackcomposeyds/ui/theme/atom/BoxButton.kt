package com.eggtart.jetpackcomposeyds.ui.theme.atom

import android.view.MotionEvent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.ButtonDefaults.outlinedButtonColors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon


enum class BoxButtonType {
    FILLED, // 가장 중요한 버튼에 사용합니다. 남용을 지양해주세요.
    TINTED, // 어중간하게 중요한 버튼에 사용합니다.
    LINE, // 덜 중요한 버튼에 사용합니다.
}

enum class BoxButtonSize {
    EXTRA_LARGE, // 화면에서 단 하나의 버튼을 강조할 때 사용합니다.
    LARGE,
    MEDIUM,
    SMALL,
}

enum class BoxButtonRounding(val dp: Dp) {
    FOUR(4.dp),
    EIGHT(8.dp),
}

private enum class BoxButtonButtonState {
    IS_DISABLED,
    IS_ENABLED,
    IS_WARNED,
}

private data class BoxButtonContentData(
    val height: Dp,
    val typo: TextStyle,
    val iconSize: IconSize,
    val horizontalPadding: Dp,
)

private enum class ButtonPressState {
    UP,
    DOWN
}


@ExperimentalComposeUiApi
@Composable
fun BoxButton(
    text: String = "",
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    boxButtonType: BoxButtonType = BoxButtonType.FILLED,
    isDisabled: Boolean = false,
    isWarned: Boolean = false,
    boxButtonSize: BoxButtonSize = BoxButtonSize.EXTRA_LARGE,
    rounding: BoxButtonRounding = BoxButtonRounding.EIGHT,
) {
    var isPressed by remember { mutableStateOf(ButtonPressState.UP) }

    val boxButtonContentData = when (boxButtonSize) {
        BoxButtonSize.EXTRA_LARGE -> {
            BoxButtonContentData(
                height = 56.dp,
                typo = YdsTheme.typography.Button1,
                iconSize = IconSize.Medium,
                horizontalPadding = 16.dp,
            )
        }
        BoxButtonSize.LARGE -> {
            BoxButtonContentData(
                height = 48.dp,
                typo = YdsTheme.typography.Button2,
                iconSize = IconSize.Medium,
                horizontalPadding = 16.dp,
            )
        }
        BoxButtonSize.MEDIUM -> {
            BoxButtonContentData(
                height = 40.dp,
                typo = YdsTheme.typography.Button2,
                iconSize = IconSize.Medium,
                horizontalPadding = 12.dp,
            )
        }
        BoxButtonSize.SMALL -> {
            BoxButtonContentData(
                height = 32.dp,
                typo = YdsTheme.typography.Button4,
                iconSize = IconSize.Small,
                horizontalPadding = 12.dp,
            )
        }
    }


    val buttonState = if (isWarned) {
        BoxButtonButtonState.IS_WARNED
    } else {
        if (isDisabled) {
            BoxButtonButtonState.IS_DISABLED
        } else {
            BoxButtonButtonState.IS_ENABLED
        }
    }


    val buttonColors = when (boxButtonType) {
        BoxButtonType.FILLED -> {
            when (buttonState) {
                BoxButtonButtonState.IS_ENABLED -> {
                    if (isPressed == ButtonPressState.UP) {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonPoint,
                            contentColor = YdsTheme.colors.buttonReversed,
                            disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                            disabledContentColor = YdsTheme.colors.buttonDisabled,
                        )
                    } else {
                        buttonColors(
                            backgroundColor = YdsTheme.colors.buttonPointPressed,
                            contentColor = YdsTheme.colors.buttonReversed,
                            disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                            disabledContentColor = YdsTheme.colors.buttonDisabled,
                        )
                    }
                }
                BoxButtonButtonState.IS_DISABLED -> {
                    buttonColors(
                        backgroundColor = YdsTheme.colors.buttonPoint,
                        contentColor = YdsTheme.colors.buttonReversed,
                        disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                        disabledContentColor = YdsTheme.colors.buttonDisabled,
                    )
                }
                BoxButtonButtonState.IS_WARNED -> {
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
        BoxButtonType.TINTED -> {
            when (buttonState) {
                BoxButtonButtonState.IS_ENABLED -> {
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
                BoxButtonButtonState.IS_DISABLED -> {
                    buttonColors(
                        backgroundColor = YdsTheme.colors.buttonDisabledBG,
                        contentColor = YdsTheme.colors.buttonDisabled,
                        disabledBackgroundColor = YdsTheme.colors.buttonDisabledBG,
                        disabledContentColor = YdsTheme.colors.buttonDisabled,
                    )
                }
                BoxButtonButtonState.IS_WARNED -> {
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
        BoxButtonType.LINE -> {
            when (buttonState) {
                BoxButtonButtonState.IS_ENABLED -> {
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
                BoxButtonButtonState.IS_DISABLED -> {
                    outlinedButtonColors(
                        backgroundColor = YdsTheme.colors.bgNormal,
                        contentColor = YdsTheme.colors.buttonDisabled,
                        disabledContentColor = YdsTheme.colors.buttonDisabled
                    )
                }
                BoxButtonButtonState.IS_WARNED -> {
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
        enabled = buttonState != BoxButtonButtonState.IS_DISABLED,
        elevation = elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        colors = buttonColors,
        border = if (boxButtonType == BoxButtonType.LINE) {
            BorderStroke(
                1.dp,
                buttonColors.contentColor(enabled = buttonState != BoxButtonButtonState.IS_DISABLED)
                    .value
            )
        } else {
            null
        },
        shape = RoundedCornerShape(rounding.dp),
    ) {
        if (leftIcon != null) {
            YdsIcon(
                id = leftIcon,
                iconSize = boxButtonContentData.iconSize,
                tint = buttonColors.contentColor(
                    enabled = (buttonState != BoxButtonButtonState.IS_DISABLED)
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
                    enabled = (buttonState != BoxButtonButtonState.IS_DISABLED)
                ).value,
            )
        }
    }

}

@ExperimentalComposeUiApi
@Preview(
    name = "PreviewBoxButton",
    showSystemUi = true,
    fontScale = 1F
)
@Composable
private fun PreviewBoxButton() {
    val type = BoxButtonType.FILLED
    val isDisabled = false
    val isWarned = true

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
                boxButtonType = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                boxButtonSize = BoxButtonSize.EXTRA_LARGE,
                rounding = BoxButtonRounding.EIGHT
            )
            BoxButton(
                text = "what a nice world!",
                leftIcon = R.drawable.ic_ground_line,
                rightIcon = R.drawable.ic_ground_line,
                boxButtonType = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                boxButtonSize = BoxButtonSize.LARGE,
                rounding = BoxButtonRounding.EIGHT
            )
            BoxButton(
                text = "what a nice world!",
                leftIcon = R.drawable.ic_ground_line,
                rightIcon = R.drawable.ic_ground_line,
                boxButtonType = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                boxButtonSize = BoxButtonSize.MEDIUM,
                rounding = BoxButtonRounding.EIGHT
            )
            BoxButton(
                text = "what a nice world!",
                leftIcon = R.drawable.ic_ground_line,
                rightIcon = R.drawable.ic_ground_line,
                boxButtonType = type,
                isDisabled = isDisabled,
                isWarned = isWarned,
                boxButtonSize = BoxButtonSize.SMALL,
                rounding = BoxButtonRounding.EIGHT
            )
        }
    }
}

