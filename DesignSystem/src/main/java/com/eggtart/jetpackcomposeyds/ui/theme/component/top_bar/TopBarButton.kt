package com.eggtart.jetpackcomposeyds.ui.theme.component.top_bar

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.base.NoRippleTextButton
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.IconSize
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.YdsIcon

data class TopBarButtonState(
    val contentState: ContentState = ContentState.Image(),
    val activateState: ActivateState = ActivateState.Enabled,
) {
    val interactionSource: MutableInteractionSource = MutableInteractionSource()

    private val isPressed
        @Composable get() = interactionSource.collectIsPressedAsState().value

    val isEnabled = activateState != ActivateState.Disabled

    sealed class ActivateState {
        object Enabled : ActivateState()
        object Disabled : ActivateState()
    }

    sealed class ContentState {
        data class Image(
            @DrawableRes val icon: Int = R.drawable.ic_ground_filled,
        ) : ContentState() {
            val iconSize: IconSize = IconSize.Medium
        }

        data class Text(
            val text: String = "",
        ) : ContentState() {
            val typo: TextStyle
                @Composable get() = YdsTheme.typography.button0
        }
    }

    val contentColor
        @Composable get() = when (activateState) {
            ActivateState.Enabled -> YdsTheme.colors.buttonNormal.maybePressed()
            ActivateState.Disabled -> YdsTheme.colors.buttonDisabled
        }

    @Composable
    fun Color.toPressedColor(): Color = when (this) {
        YdsTheme.colors.buttonNormal -> YdsTheme.colors.buttonNormalPressed
        else -> this
    }

    @Composable
    fun Color.maybePressed() =
        if (isPressed) {
            this.toPressedColor()
        } else {
            this
        }
}

@Composable
fun rememberTopBarButtonState(
    contentState: TopBarButtonState.ContentState = TopBarButtonState.ContentState.Image(),
    activateState: TopBarButtonState.ActivateState = TopBarButtonState.ActivateState.Enabled,
) = remember(contentState, activateState) {
    TopBarButtonState(
        contentState,
        activateState,
    )
}

@Composable
fun TopBarButton(
    topBarButtonState: TopBarButtonState = rememberTopBarButtonState(),
    onClick: () -> Unit
) {
    topBarButtonState.run {
        NoRippleTextButton(
            onClick = onClick,
            enabled = isEnabled,
            interactionSource = interactionSource,
            contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            when (contentState) {
                is TopBarButtonState.ContentState.Image -> {
                    YdsIcon(
                        id = contentState.icon,
                        iconSize = contentState.iconSize,
                        tint = contentColor,
                    )
                }
                is TopBarButtonState.ContentState.Text -> {
                    Text(
                        text = contentState.text,
                        color = contentColor,
                        style = contentState.typo,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewTopBarButton() {

    val context = LocalContext.current

    fun onClick() {
        Toast.makeText(
            context,
            "Click!",
            Toast.LENGTH_SHORT
        ).show()
    }

    val state = rememberTopBarButtonState(
        contentState = TopBarButtonState.ContentState.Text("버튼"),
        activateState = TopBarButtonState.ActivateState.Enabled
    )

    JetpackComposeYDSTheme {

        TopBarButton(
            topBarButtonState = state
        ) {
            onClick()
        }

    }
}



