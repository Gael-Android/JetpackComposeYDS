package com.eggtart.jetpackcomposeyds.ui.theme.foundation

import com.eggtart.jetpackcomposeyds.R

internal enum class IconState {
    LINE,
    FILLED,
}

internal enum class IconSize(value: Int) {
    PX16(16),
    PX20(20),
    PX24(24),
    PX48(48),
}

internal data class Icon(
    val iconState: IconState = IconState.LINE,
    val iconSize: IconSize = IconSize.PX24,
    val drawable: Int,
)

// TODO: 2021-12-12 must implement





