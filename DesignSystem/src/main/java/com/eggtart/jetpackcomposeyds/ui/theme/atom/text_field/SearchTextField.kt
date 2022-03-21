package com.eggtart.jetpackcomposeyds.ui.theme.atom.text_field

import android.widget.Toast
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalContentColor
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.base.noRippleClickable
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon

data class SearchTextFieldState(
    val text: String = "",
    val placeHolderText: String = "",
    val activateState: ActivateState = ActivateState.Enabled,
    val interactionSource: MutableInteractionSource = MutableInteractionSource(),
) {
    val isEnabled = activateState == ActivateState.Enabled

    val isTyping
        @Composable get() = interactionSource.collectIsFocusedAsState().value and text.isNotBlank()

    sealed class ActivateState {
        object Enabled : ActivateState()
        object Disabled : ActivateState()
    }

    fun updateText(text: String) = copy(text = text)

    fun emptyText() = copy(text = "")
}

@Composable
fun rememberSearchTextField(
    text: String = "",
    placeHolderText: String = "",
    activateState: SearchTextFieldState.ActivateState = SearchTextFieldState.ActivateState.Enabled,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) = remember(
    text,
    placeHolderText,
    activateState,
    interactionSource
) {
    mutableStateOf(
        SearchTextFieldState(
            text,
            placeHolderText,
            activateState,
            interactionSource
        )
    )
}

@Composable
fun SearchTextField(
    searchTextFieldState: SearchTextFieldState,
    onValueChange: (String) -> Unit,
    onX: () -> Unit,
    onSearch: () -> Unit,
) {
    YdsTheme.colors.run {
        OutlinedTextField(
            value = searchTextFieldState.text,
            onValueChange = {
                onValueChange(it)
            },
            modifier = Modifier
                .width(350.dp)
                .height(48.dp),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            enabled = searchTextFieldState.isEnabled,
            interactionSource = searchTextFieldState.interactionSource,
            placeholder = {
                Text(
                    text = searchTextFieldState.placeHolderText,
                    style = YdsTheme.typography.body1
                )
            },
            textStyle = YdsTheme.typography.body1,
            leadingIcon = {
                YdsIcon(
                    id = R.drawable.ic_search_line,
                    iconSize = IconSize.Small,
                    tint = if (searchTextFieldState.isTyping) {
                        textSecondary
                    } else {
                        LocalContentColor.current
                    }
                )
            },
            trailingIcon = {
                if (searchTextFieldState.isTyping) {
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
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch()
                }
            ),
            colors = outlinedTextFieldColors(
                textColor = textSecondary,
                disabledTextColor = textDisabled,
                backgroundColor = inputFieldElevated,
                cursorColor = textPointed,
                errorCursorColor = textPointed,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent,
                errorBorderColor = textWarned,
                leadingIconColor = textTertiary,
                disabledLeadingIconColor = textDisabled,
                errorLeadingIconColor = Color.Transparent,
                trailingIconColor = textTertiary,
                disabledTrailingIconColor = textDisabled,
                errorTrailingIconColor = Color.Transparent,
                focusedLabelColor = Color.Transparent,
                unfocusedLabelColor = Color.Transparent,
                disabledLabelColor = Color.Transparent,
                errorLabelColor = Color.Transparent,
                placeholderColor = textTertiary,
                disabledPlaceholderColor = textDisabled
            )
        )
    }


}


@Preview
@Composable
private fun Preview() {
    val context = LocalContext.current

    var state by rememberSearchTextField(
        placeHolderText = "플레이스 홀더",
    )

    SearchTextField(
        searchTextFieldState = state,
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
        },
        onSearch = {
            Toast.makeText(
                context,
                "onSearch!",
                Toast.LENGTH_SHORT
            ).show()
        }
    )
}

