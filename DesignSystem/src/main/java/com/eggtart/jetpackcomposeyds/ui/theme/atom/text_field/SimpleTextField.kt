package com.eggtart.jetpackcomposeyds.ui.theme.atom.text_field

import android.widget.Toast
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.base.noRippleClickable
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon

data class SimpleTextFieldState(
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

    fun updateText(text: String) = copy(text = text)

    fun emptyText() = copy(text = "")

    fun toPositive() = copy(eventState = EventState.Positive)

    fun toNegative() = copy(eventState = EventState.Negative)

    fun toNone() = copy(eventState = EventState.None)
}

@Composable
fun rememberSimpleTextFieldState(
    fieldLabelText: String = "",
    placeHolderText: String = "",
    helperLabelText: String = "",
    text: String = "",
    activateState: SimpleTextFieldState.ActivateState = SimpleTextFieldState.ActivateState.Enabled,
    eventState: SimpleTextFieldState.EventState = SimpleTextFieldState.EventState.None,
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
        SimpleTextFieldState(
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
fun SimpleTextField(
    simpleTextFieldState: SimpleTextFieldState,
    onValueChange: (String) -> Unit,
    onX: () -> Unit,
    validate: () -> Unit
) {
    YdsTheme.colors.run {
        Column {
            Text(
                text = simpleTextFieldState.fieldLabelText,
                color = simpleTextFieldState.labelColor,
                style = YdsTheme.typography.subTitle3
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = simpleTextFieldState.text,
                onValueChange = {
                    onValueChange(it)
                    validate()
                },
                modifier = Modifier
                    .width(350.dp)
                    .height(48.dp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                isError = simpleTextFieldState.isError,
                enabled = simpleTextFieldState.isEnabled,
                interactionSource = simpleTextFieldState.interactionSource,
                placeholder = {
                    Text(
                        text = simpleTextFieldState.placeHolderText,
                        style = YdsTheme.typography.body1
                    )
                },
                textStyle = YdsTheme.typography.body1,
                trailingIcon = {
                    if (simpleTextFieldState.isTyping) {
                        YdsIcon(
                            id = R.drawable.ic_x_line,
                            iconSize = IconSize.ExtraSmall,
                            tint = buttonNormal,
                            modifier = Modifier.noRippleClickable {
                                onX()
                            }
                        )
                    }
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
                    focusedBorderColor = simpleTextFieldState.boarderColor,
                    unfocusedBorderColor = simpleTextFieldState.boarderColor,
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
                    disabledPlaceholderColor = textDisabled,
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                simpleTextFieldState.helperLabelText,
                modifier = Modifier.padding(horizontal = 8.dp),
                color = simpleTextFieldState.helperColor,
                style = YdsTheme.typography.caption1
            )
        }
    }


}


@Preview
@Composable
private fun Preview() {
    val context = LocalContext.current

    var state by rememberSimpleTextFieldState(
        fieldLabelText = "필드 라벨 텍스트",
        placeHolderText = "플레이스 홀더",
        helperLabelText = "도움말 텍스트"
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

    SimpleTextField(
        simpleTextFieldState = state,
        onValueChange = {
            state = state.updateText(it)
        },
        onX = {
            Toast.makeText(
                context,
                "Erase!",
                Toast.LENGTH_SHORT
            ).show()
            state = state.emptyText()
        }
    ) {
        validate()
    }
}

