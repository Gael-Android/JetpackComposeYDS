package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme

data class ToggleState(
    val activateState: ActivateState = ActivateState.Enabled,
    val selectedState: SelectedState = SelectedState.Selected
) {
    val isSelected = selectedState == SelectedState.Selected
    val isEnabled = activateState == ActivateState.Enabled

    sealed class ActivateState {
        object Disabled : ActivateState()
        object Enabled : ActivateState()
    }

    sealed class SelectedState {
        object Selected : SelectedState()
        object NotSelected : SelectedState()

        fun toggle() = when (this) {
            NotSelected -> Selected
            Selected -> NotSelected
        }
    }

    val trackColor
        @Composable get() = when (activateState) {
            ActivateState.Enabled -> when (selectedState) {
                SelectedState.Selected -> YdsTheme.colors.buttonPoint
                SelectedState.NotSelected -> YdsTheme.colors.buttonBG
            }
            ActivateState.Disabled -> YdsTheme.colors.buttonBG
        }

    val thumbColor
        @Composable get() = when (activateState) {
            ActivateState.Enabled -> YdsTheme.colors.buttonReversed
            ActivateState.Disabled -> YdsTheme.colors.buttonDisabled
        }

    val startPadding
        @Composable get() = when (selectedState) {
            SelectedState.Selected -> 22.dp
            SelectedState.NotSelected -> 2.dp
        }

    val endPadding
        @Composable get() = when (selectedState) {
            SelectedState.Selected -> 2.dp
            SelectedState.NotSelected -> 22.dp
        }

    fun updateStateOnToggle() = this.copy(
        selectedState = selectedState.toggle()
    )
}

@Composable
fun rememberToggleState(
    activateState: ToggleState.ActivateState = ToggleState.ActivateState.Enabled,
    selectedState: ToggleState.SelectedState = ToggleState.SelectedState.Selected
) = remember(
    activateState, selectedState
) {
    mutableStateOf(
        ToggleState(
            activateState,
            selectedState
        )
    )
}


@Composable
fun Toggle(
    toggleState: ToggleState,
    onToggle: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(51.dp, 31.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(toggleState.trackColor)
            .padding(
                toggleState.startPadding,
                2.dp,
                toggleState.endPadding,
                2.dp
            )
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                enabled = toggleState.isEnabled
            ) {
                onToggle()
            }
    ) {
        Surface(
            color = toggleState.thumbColor,
            shape = CircleShape,
            modifier = Modifier
                .size(27.dp)
                .border(
                    width = YdsTheme.boarder.thin,
                    color = YdsTheme.colors.borderNormal,
                    shape = CircleShape
                )
        ) {}
    }
}

@Preview
@Composable
fun PreviewToggle() {
    var state by rememberToggleState(
        activateState = ToggleState.ActivateState.Disabled,
        selectedState = ToggleState.SelectedState.NotSelected
    )

    JetpackComposeYDSTheme {
        Toggle(toggleState = state) {
            state = state.updateStateOnToggle()
        }
    }
}




