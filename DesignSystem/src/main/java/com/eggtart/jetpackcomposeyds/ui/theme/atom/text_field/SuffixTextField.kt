package com.eggtart.jetpackcomposeyds.ui.theme.atom.text_field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme

data class SuffixTextFieldState(
    val fieldLabelText: String = "",
    val placeHolderText: String = "",
    val helperLabelText: String = "",
    val text: String = "",
    val suffixLabelText: String = "",
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

    val suffixLabelTextColor
        @Composable get() = when (activateState) {
            ActivateState.Enabled -> YdsTheme.colors.textTertiary
            ActivateState.Disabled -> YdsTheme.colors.textDisabled
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

    fun updateText(text: String) = copy(text = text)

    fun toPositive() = copy(eventState = EventState.Positive)

    fun toNegative() = copy(eventState = EventState.Negative)

    fun toNone() = copy(eventState = EventState.None)
}

@Composable
fun rememberSuffixTextField(
    fieldLabelText: String = "",
    placeHolderText: String = "",
    helperLabelText: String = "",
    text: String = "",
    suffixLabelText: String = "",
    activateState: SuffixTextFieldState.ActivateState = SuffixTextFieldState.ActivateState.Enabled,
    eventState: SuffixTextFieldState.EventState = SuffixTextFieldState.EventState.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) = remember(
    fieldLabelText,
    placeHolderText,
    helperLabelText,
    text,
    suffixLabelText,
    activateState,
    eventState,
    interactionSource
) {
    mutableStateOf(
        SuffixTextFieldState(
            fieldLabelText,
            placeHolderText,
            helperLabelText,
            text,
            suffixLabelText,
            activateState,
            eventState,
            interactionSource
        )
    )
}

@Composable
fun SuffixTextField(
    suffixTextFieldState: SuffixTextFieldState,
    onValueChange: (String) -> Unit,
    validate: () -> Unit
) {
    YdsTheme.colors.run {
        Column {
            Text(
                text = suffixTextFieldState.fieldLabelText,
                color = suffixTextFieldState.labelColor,
                style = YdsTheme.typography.SubTitle3
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = suffixTextFieldState.text,
                onValueChange = {
                    onValueChange(it)
                    validate()
                },
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                isError = suffixTextFieldState.isError,
                enabled = suffixTextFieldState.isEnabled,
                interactionSource = suffixTextFieldState.interactionSource,
                placeholder = {
                    Text(
                        text = suffixTextFieldState.placeHolderText,
                        style = YdsTheme.typography.Body1
                    )
                },
                textStyle = YdsTheme.typography.Body1,
                trailingIcon = {
                    Text(
                        text = suffixTextFieldState.suffixLabelText,
                        color = suffixTextFieldState.suffixLabelTextColor,
                        style = YdsTheme.typography.Body1
                    )
                },
//                keyboardActions = KeyboardActions {
//                    validate()
//                },
                colors = outlinedTextFieldColors(
                    textColor = textSecondary,
                    disabledTextColor = textDisabled,
                    backgroundColor = inputFieldElevated,
                    cursorColor = textPointed,
                    errorCursorColor = textPointed,
                    focusedBorderColor = suffixTextFieldState.boarderColor,
                    unfocusedBorderColor = suffixTextFieldState.boarderColor,
                    disabledBorderColor = Color.Transparent,
                    errorBorderColor = textWarned,
                    leadingIconColor = Color.Transparent,
                    disabledLeadingIconColor = Color.Transparent,
                    errorLeadingIconColor = Color.Transparent,
                    trailingIconColor = Color.Transparent,
                    disabledTrailingIconColor = Color.Transparent,
                    errorTrailingIconColor = Color.Transparent,
                    focusedLabelColor = Color.Transparent,
                    unfocusedLabelColor = Color.Transparent,
                    disabledLabelColor = Color.Transparent,
                    errorLabelColor = Color.Transparent,
                    placeholderColor = textTertiary,
                    disabledPlaceholderColor = textDisabled
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                suffixTextFieldState.helperLabelText,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = suffixTextFieldState.helperColor,
                style = YdsTheme.typography.Caption1
            )
        }
    }


}


@Preview
@Composable
private fun Preview() {
    var state by rememberSuffixTextField(
        fieldLabelText = "필드 라벨 텍스트",
        placeHolderText = "플레이스 홀더",
        helperLabelText = "도움말 텍스트",
        suffixLabelText = "@soongsil.ac.kr"
    )

    fun validate() {
        if (state.text == "ok") {
            state = state.toPositive()
        } else if (state.text == "bad") {
            state = state.toNegative()
        } else {
            state = state.toNone()
        }
    }

    SuffixTextField(
        suffixTextFieldState = state,
        onValueChange = {
            state = state.updateText(it)
        },
    ) {
        validate()
    }
}

