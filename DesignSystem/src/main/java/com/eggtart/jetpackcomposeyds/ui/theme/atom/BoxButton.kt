package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.annotation.DrawableRes
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.*
import java.lang.reflect.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


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

enum class Rounding {
    FOUR,
    EIGHT,
}

enum class HorizontalPadding {
    TWELVE,
    SIXTEEN,
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

data class BoxButtonColorData(
    val textColor: Color,
    val iconColor: Color,
    val strokeColor: Color,
    val backgroundColor: Color,
) {
}

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
        if (isDisabled) {
            ButtonState.IS_DISABLED
        } else {
            ButtonState.IS_ENABLED
        }
    } else {
        ButtonState.IS_WARNED
    }

    val buttonColors = when (type) {
        Type.FILLED -> {
            when (buttonState) {
                ButtonState.IS_ENABLED -> {
//                    BoxButtonColorData(
//                        textColor = YdsTheme.colors.buttonReversed,
//                        iconColor = YdsTheme.colors.buttonReversed,
//                        strokeColor = YdsTheme.colors.buttonPoint,
//                        backgroundColor = YdsTheme.colors.buttonPoint,
//                    )
                    buttonColors(
                        backgroundColor = YdsTheme.colors.buttonPoint,
                        contentColor = YdsTheme.colors.buttonReversed,
                        disabledBackgroundColor = 
                    )
                }
                ButtonState.IS_DISABLED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonDisabled,
                        iconColor = YdsTheme.colors.buttonDisabled,
                        strokeColor = YdsTheme.colors.buttonDisabledBG,
                        backgroundColor = YdsTheme.colors.buttonDisabledBG,
                    )
                }
                ButtonState.IS_WARNED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonReversed,
                        iconColor = YdsTheme.colors.buttonReversed,
                        strokeColor = YdsTheme.colors.buttonDisabledBG,
                        backgroundColor = YdsTheme.colors.buttonDisabledBG,
                    )
                }
            }
        }
        Type.TINTED -> {
            when (buttonState) {
                ButtonState.IS_ENABLED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonPoint,
                        iconColor = YdsTheme.colors.buttonPoint,
                        strokeColor = YdsTheme.colors.buttonPointBG,
                        backgroundColor = YdsTheme.colors.buttonPointBG,
                    )
                }
                ButtonState.IS_DISABLED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonDisabled,
                        iconColor = YdsTheme.colors.buttonDisabled,
                        strokeColor = YdsTheme.colors.buttonDisabledBG,
                        backgroundColor = YdsTheme.colors.buttonDisabledBG,
                    )
                }
                ButtonState.IS_WARNED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonWarned,
                        iconColor = YdsTheme.colors.buttonWarned,
                        strokeColor = YdsTheme.colors.buttonWarnedBG,
                        backgroundColor = YdsTheme.colors.buttonWarnedBG,
                    )
                }
            }
        }
        Type.LINE -> {
            when (buttonState) {
                ButtonState.IS_ENABLED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonPoint,
                        iconColor = YdsTheme.colors.buttonPoint,
                        strokeColor = YdsTheme.colors.buttonPoint,
                        backgroundColor = YdsTheme.colors.buttonNormal,
                    )
                }
                ButtonState.IS_DISABLED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonDisabled,
                        iconColor = YdsTheme.colors.buttonDisabled,
                        strokeColor = YdsTheme.colors.buttonDisabled,
                        backgroundColor = YdsTheme.colors.buttonNormal,
                    )
                }
                ButtonState.IS_WARNED -> {
                    BoxButtonColorData(
                        textColor = YdsTheme.colors.buttonWarned,
                        iconColor = YdsTheme.colors.buttonWarned,
                        strokeColor = YdsTheme.colors.buttonWarned,
                        backgroundColor = YdsTheme.colors.buttonNormal,
                    )
                }
            }
        }
    }

    when (type) {
        Type.FILLED -> {
            Button(
                onClick = {

                },
                enabled = buttonState == ButtonState.IS_ENABLED,
                colors = buttonColors(
                    backgroundColor = boxButtonColorData.backgroundColor,
                    contentColor = boxButtonColorData.,
                    disabledBackgroundColor =,
                    disabledContentColor =,
                )
            ) {

            }
        }
        Type.TINTED -> {
            Button(

            ) {

            }
        }
        Type.LINE -> {
            Button(

            ) {

            }
        }
    }

}
