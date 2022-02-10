package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.LocalColors
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize

data class CheckBoxState(
    val text: String,
    val disabledState: DisabledState,
    val selectedState: SelectedState,
    val sizeState: SizeState,
) {
    sealed class DisabledState {
        object Disabled : DisabledState()
        object Enabled : DisabledState()
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
    fun getColor(): Color = when (disabledState) {
        DisabledState.Disabled -> {
            LocalColors.current.buttonDisabled
        }
        DisabledState.Enabled -> {
            when (selectedState) {
                SelectedState.NotSelected ->
                    LocalColors.current.buttonNormal
                SelectedState.Selected ->
                    LocalColors.current.buttonPoint
            }
        }
    }

    @Composable
    fun DrawIcon() = when (selectedState) {
        SelectedState.NotSelected -> {
            Icon(
                painter = painterResource(id = R.drawable.ic_checkcircle_line),
                contentDescription = "notSelected",
                modifier = Modifier
                    .size(sizeState.iconSize.value),
                tint = getColor()
            )
        }
        SelectedState.Selected -> {
            Icon(
                painter = painterResource(id = R.drawable.ic_checkcircle_filled),
                contentDescription = "selected",
                modifier = Modifier.size(sizeState.iconSize.value),
                tint = getColor()
            )
        }
    }

    @Composable
    fun DrawText() {
        Text(
            text = text,
            color = getColor()
        )
    }

    fun onClick() = this.copy(
        selectedState = if (isClickable()) {
            selectedState.toggle()
        } else {
            selectedState
        },
    )

    fun isClickable() = disabledState == DisabledState.Enabled
}

@Composable
fun CheckBox(
    text: String,
    disabledState: CheckBoxState.DisabledState,
    selectedState: CheckBoxState.SelectedState,
    sizeState: CheckBoxState.SizeState,
) {
    var checkBoxState by remember {
        mutableStateOf(
            CheckBoxState(
                text = text,
                disabledState = disabledState,
                selectedState = selectedState,
                sizeState = sizeState
            )
        )
    }

    Row(
        modifier = Modifier.toggleable(
            value = checkBoxState.isClickable(),
            interactionSource = MutableInteractionSource(),
            indication = null
        ) {
            checkBoxState = checkBoxState.onClick()
        },
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

@Composable
@Preview
fun PreviewCheckBox() {
    JetpackComposeYDSTheme {
        val sizeList = listOf(
            CheckBoxState.SizeState.Large,
            CheckBoxState.SizeState.Medium,
            CheckBoxState.SizeState.Small,
        )

        val disabledList = listOf(
            CheckBoxState.DisabledState.Disabled,
            CheckBoxState.DisabledState.Enabled
        )

        val selectedList = listOf(
            CheckBoxState.SelectedState.Selected,
            CheckBoxState.SelectedState.NotSelected
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxWidth(),
        ) {
            for (size in sizeList) {
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    for (disabled in disabledList) {
                        for (selected in selectedList)
                            CheckBox(
                                text = "텍스트",
                                disabledState = disabled,
                                selectedState = selected,
                                sizeState = size
                            )
                    }
                }
            }
        }
    }
}