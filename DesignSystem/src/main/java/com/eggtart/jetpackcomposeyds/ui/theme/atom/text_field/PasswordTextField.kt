package com.eggtart.jetpackcomposeyds.ui.theme.atom.text_field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.base.noRippleClickable
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon

data class PasswordTextFieldState(
    val fieldLabelText: String = "",
    val placeHolderText: String = "",
    val helperLabelText: String = "",
    val text: String = "",
    val activateState: ActivateState = ActivateState.Enabled,
    val eventState: EventState = EventState.None,
    val interactionSource: MutableInteractionSource = MutableInteractionSource(),
) {
    val isError = eventState == EventState.Negative

    val isEnabled = activateState == ActivateState.Enabled

    val isFocused
        @Composable get() = interactionSource.collectIsFocusedAsState().value

    val isTyping
        @Composable get() = interactionSource.collectIsFocusedAsState().value and text.isNotBlank()

    val labelColor
        @Composable get() = YdsTheme.colors.run {
            when (activateState) {
                ActivateState.Enabled -> textSecondary
                ActivateState.Disabled -> textDisabled
            }
        }

    val helperColor
        @Composable get() = YdsTheme.colors.run {
            when (activateState) {
                ActivateState.Enabled -> when (eventState) {
                    EventState.None, EventState.Positive -> textTertiary
                    EventState.Negative -> textWarned
                }
                ActivateState.Disabled -> textDisabled
            }
        }

    val boarderColor
        @Composable get() = when (eventState) {
            EventState.Positive -> YdsTheme.colors.textPointed
            EventState.Negative -> YdsTheme.colors.textWarned
            EventState.None -> Color.Transparent
        }

    sealed class ActivateState {
        object Enabled : ActivateState()
        object Disabled : ActivateState()
    }

    sealed class EventState {
        object None : EventState()
        object Positive : EventState()
        object Negative : EventState()
    }

    sealed class VisibilityState {
        object Hide : VisibilityState()
        object Show : VisibilityState()

        fun toggle() = when (this) {
            Hide -> Show
            Show -> Hide
        }
    }

    fun updateText(text: String) = copy(text = text)

    fun emptyText() = copy(text = "")

    fun toPositive() = copy(eventState = EventState.Positive)

    fun toNegative() = copy(eventState = EventState.Negative)

    fun toNone() = copy(eventState = EventState.None)
}

@Composable
fun rememberPasswordTextFieldState(
    fieldLabelText: String = "",
    placeHolderText: String = "",
    helperLabelText: String = "",
    text: String = "",
    activateState: PasswordTextFieldState.ActivateState = PasswordTextFieldState.ActivateState.Enabled,
    eventState: PasswordTextFieldState.EventState = PasswordTextFieldState.EventState.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) = remember(
    fieldLabelText,
    placeHolderText,
    helperLabelText,
    text,
    activateState,
    eventState,
    interactionSource
) {
    mutableStateOf(
        PasswordTextFieldState(
            fieldLabelText,
            placeHolderText,
            helperLabelText,
            text,
            activateState,
            eventState,
            interactionSource
        )
    )
}


@Composable
fun PasswordTextField(
    passwordTextFieldState: PasswordTextFieldState,
    onValueChange: (String) -> Unit,
    validate: () -> Unit,
) {
    var isHide by remember {
        mutableStateOf(true)
    }

    YdsTheme.colors.run {
        Column {
            Text(
                text = passwordTextFieldState.fieldLabelText,
                color = passwordTextFieldState.labelColor,
                style = YdsTheme.typography.subTitle3
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = passwordTextFieldState.text,
                onValueChange = {
                    onValueChange(it)
                    validate()
                },
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                isError = passwordTextFieldState.isError,
                enabled = passwordTextFieldState.isEnabled,
                interactionSource = passwordTextFieldState.interactionSource,
                placeholder = {
                    Text(
                        text = passwordTextFieldState.placeHolderText,
                        style = YdsTheme.typography.body1
                    )
                },
                visualTransformation = if (isHide) PasswordVisualTransformation() else VisualTransformation.None,
                textStyle = YdsTheme.typography.body1,
                trailingIcon = {
                    if (passwordTextFieldState.isTyping) {
                        YdsIcon(
                            id = if (isHide) {
                                R.drawable.ic_eyeclosed_line
                            } else {
                                R.drawable.ic_eyeopen_line
                            },
                            iconSize = IconSize.Medium,
                            modifier = Modifier.noRippleClickable {
                                isHide = !isHide
                            }
                        )
                    }
                },
//                keyboardActions = KeyboardActions {
//                    validate()
//                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = textSecondary,
                    disabledTextColor = textDisabled,
                    backgroundColor = inputFieldElevated,
                    cursorColor = textPointed,
                    errorCursorColor = textPointed,
                    focusedBorderColor = passwordTextFieldState.boarderColor,
                    unfocusedBorderColor = passwordTextFieldState.boarderColor,
                    disabledBorderColor = Color.Transparent,
                    errorBorderColor = textWarned,
                    leadingIconColor = Color.Transparent,
                    disabledLeadingIconColor = Color.Transparent,
                    errorLeadingIconColor = Color.Transparent,
                    trailingIconColor = buttonNormal,
                    disabledTrailingIconColor = Color.Transparent,
                    errorTrailingIconColor = buttonNormal,
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent,
                    disabledLabelColor = Color.Transparent,
                    errorLabelColor = Color.Transparent,
                    placeholderColor = textTertiary,
                    disabledPlaceholderColor = textDisabled,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                passwordTextFieldState.helperLabelText,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = passwordTextFieldState.helperColor,
                style = YdsTheme.typography.caption1
            )
        }
    }


}

@Preview
@Composable
private fun Preview() {
    val context = LocalContext.current

    var state by rememberPasswordTextFieldState(
        fieldLabelText = "필드 라벨 텍스트",
        placeHolderText = "플레이스 홀더",
        helperLabelText = "도움말 텍스트"
    )

    fun validate() {
        state = when (state.text) {
            "ok" -> {
                state.toPositive()
            }
            "bad" -> {
                state.toNegative()
            }
            else -> {
                state.toNone()
            }
        }
    }

    PasswordTextField(
        passwordTextFieldState = state,
        onValueChange = {
            state = state.updateText(it)
        },
    ) {
        validate()
    }
}