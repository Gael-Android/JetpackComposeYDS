package com.eggtart.jetpackcomposeyds.ui.theme.foundation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R

enum class IconSize(val value: Dp) {
    EXTRA_SMALL(16.dp),
    SMALL(20.dp),
    MEDIUM(24.dp),
    LARGE(48.dp)
}

@Composable
fun YdsIcon(
    @DrawableRes id: Int,
    iconSize: IconSize = IconSize.MEDIUM,
    tint: Color,
) {
    Icon(
        imageVector = ImageVector
            .vectorResource(id = id),
        contentDescription = "$id",
        modifier = Modifier.size(iconSize.value),
        tint = tint
    )
}











