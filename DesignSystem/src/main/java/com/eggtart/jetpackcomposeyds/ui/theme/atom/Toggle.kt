package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.compose.material.Switch
import androidx.compose.runtime.*

//data class ToggleColor(
//    val
//)

sealed class EnabledState(val value: Boolean) {
    object isEnabled : EnabledState(true)
    object isDisabled : EnabledState(false)
}

sealed class SelectedState(val value: Boolean) {
    object isSelected : SelectedState(true)
    object isNotSelected : SelectedState(false)

    fun toggle(checked: Boolean): SelectedState =
        if (checked) {
            isNotSelected
        } else {
            isSelected
        }
}

@Composable
fun Toggle(
    enabledState: MutableState<EnabledState> = remember {
        mutableStateOf(EnabledState.isEnabled)
    },
    selectedState: MutableState<SelectedState> = remember {
        mutableStateOf(SelectedState.isSelected)
    }
) {

    Switch(
        checked = selectedState.value.value,
        onCheckedChange = { selectedState.value = selectedState.value.toggle(it) },
        enabled = enabledState.value.value
    )
}



