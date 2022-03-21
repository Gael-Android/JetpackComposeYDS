package com.eggtart.jetpackcomposeyds.ui.theme.component.top_bar

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme

@Composable
fun SingleTitleTopBar(
    title: String = "",
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        backgroundColor = YdsTheme.colors.bgElevated,
        contentColor = YdsTheme.colors.textPrimary,
        elevation = 0.dp,
        contentPadding = PaddingValues(end = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier.padding(16.dp, 17.dp, 16.dp, 8.dp),
                text = title,
                style = YdsTheme.typography.title2,
                color = YdsTheme.colors.textPrimary
            )

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(0.dp)
                    .align(Alignment.TopEnd),
                verticalAlignment = Alignment.CenterVertically
            ) {
                actions()
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSingleTitleTopBar() {
    JetpackComposeYDSTheme {
        Column {
            SingleTitleTopBar(
                title = "타이틀",
                actions = {
                    TopBarButton {
                    }
                    TopBarButton {
                    }
                }
            )
            SingleTitleTopBar(
                title = "타이틀",
                actions = {
                    TopBarButton {
                    }
                }
            )
            SingleTitleTopBar(
                title = "타이틀",
                actions = {

                }
            )
            SingleTitleTopBar(
                title = "타이틀",
                actions = {

                }
            )
            SingleTitleTopBar(
                actions = {

                }
            )
        }
    }
}