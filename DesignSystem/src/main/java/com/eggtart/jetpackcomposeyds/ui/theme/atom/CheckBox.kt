package com.eggtart.jetpackcomposeyds.ui.theme.atom

import android.widget.Toast
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize

data class CheckBoxState(
    val text: String,
    val activateState: ActivateState,
    val selectedState: SelectedState,
    val sizeState: SizeState,
) {
    val color: Color
        @Composable get() = when (activateState) {
            ActivateState.Disabled -> {
                YdsTheme.colors.buttonDisabled
            }
            ActivateState.Enabled -> {
                when (selectedState) {
                    SelectedState.NotSelected ->
                        YdsTheme.colors.buttonNormal
                    SelectedState.Selected ->
                        YdsTheme.colors.buttonPoint
                }
            }
        }

    val isActive = activateState == ActivateState.Enabled
    val isSelected = selectedState == SelectedState.Selected

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

    sealed class SizeState(
        val marginBetween: Dp,
        val iconSize: IconSize
    ) {
        object Small : SizeState(4.dp, IconSize.ExtraSmall)
        object Medium : SizeState(8.dp, IconSize.Small)
        object Large : SizeState(8.dp, IconSize.Medium)
    }

    @Composable
    internal fun DrawIcon() = when (selectedState) {
        SelectedState.NotSelected -> {
            Icon(
                painter = painterResource(id = R.drawable.ic_checkcircle_line),
                contentDescription = "notSelected",
                modifier = Modifier
                    .size(sizeState.iconSize.value),
                tint = color
            )
        }
        SelectedState.Selected -> {
            Icon(
                painter = painterResource(id = R.drawable.ic_checkcircle_filled),
                contentDescription = "selected",
                modifier = Modifier.size(sizeState.iconSize.value),
                tint = color
            )
        }
    }

    @Composable
    internal fun DrawText() {
        Text(
            text = text,
            color = color
        )
    }

    fun updateStateOnToggle() = this.copy(
        selectedState = selectedState.toggle()
    )
}

@Composable
fun rememberCheckBoxState(
    text: String = "",
    activateState: CheckBoxState.ActivateState = CheckBoxState.ActivateState.Disabled,
    selectedState: CheckBoxState.SelectedState = CheckBoxState.SelectedState.Selected,
    sizeState: CheckBoxState.SizeState = CheckBoxState.SizeState.Small,
) = remember(text, activateState, selectedState, sizeState) {
    mutableStateOf(
        CheckBoxState(text, activateState, selectedState, sizeState)
    )
}

@Composable
fun CheckBox(
    checkBoxState: CheckBoxState,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.toggleable(
            value = checkBoxState.isSelected,
            enabled = checkBoxState.isActive,
            interactionSource = MutableInteractionSource(),
            indication = null,
            onValueChange = onCheckedChange
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        checkBoxState.DrawIcon()
        Spacer(
            modifier = Modifier.width(
                checkBoxState.sizeState.marginBetween
            )
        )
        checkBoxState.DrawText()
    }
}

@Preview
@Composable
fun CheckBoxStateControl() {
    val context = LocalContext.current

    var controlState by rememberCheckBoxState(
        text = "텍스트",
        activateState = CheckBoxState.ActivateState.Enabled,
        selectedState = CheckBoxState.SelectedState.Selected,
        sizeState = CheckBoxState.SizeState.Large
    )

    fun onCheck(it: Boolean) {
        Toast.makeText(
            context,
            "$it",
            Toast.LENGTH_SHORT
        ).show()
    }

    JetpackComposeYDSTheme {
        CheckBox(
            controlState
        ) {
            controlState = controlState.updateStateOnToggle()
            onCheck(it)
        }
    }
}

@Composable
@Preview
fun PreviewCheckBox() {
    JetpackComposeYDSTheme {
        val context = LocalContext.current

        val sizeList = listOf(
            CheckBoxState.SizeState.Large,
            CheckBoxState.SizeState.Medium,
            CheckBoxState.SizeState.Small,
        )

        val disabledList = listOf(
            CheckBoxState.ActivateState.Disabled,
            CheckBoxState.ActivateState.Enabled
        )

        val selectedList = listOf(
            CheckBoxState.SelectedState.Selected,
            CheckBoxState.SelectedState.NotSelected
        )

        fun onCheck() {
            Toast.makeText(
                context,
                "Click!",
                Toast.LENGTH_SHORT
            ).show()
        }

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(),
        ) {
            for (size in sizeList) {
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    for (disabled in disabledList) {
                        for (selected in selectedList) {

                            var controlState by rememberCheckBoxState(
                                text = "텍스트",
                                activateState = disabled,
                                selectedState = selected,
                                sizeState = size
                            )

                            CheckBox(
                                controlState
                            ) {
                                controlState = controlState.updateStateOnToggle()
                                onCheck()
                            }
                        }
                    }
                }
            }
        }
    }
}