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
fun DoubleTitleTopBar(
    title: String = "",
    subtitle: String = "",
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp),
        backgroundColor = YdsTheme.colors.bgElevated,
        contentColor = YdsTheme.colors.textPrimary,
        elevation = 0.dp,
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 12.dp,
                    end = 16.dp,
                    bottom = 8.dp
                )
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    text = subtitle,
                    style = YdsTheme.typography.body2,
                    color = YdsTheme.colors.textPrimary
                )
                Text(
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    text = title,
                    style = YdsTheme.typography.title2,
                    color = YdsTheme.colors.textPrimary
                )
            }

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
private fun PreviewDoubleTitleTopBar() {
    JetpackComposeYDSTheme {
        Column {
            DoubleTitleTopBar(
                title = "타이틀",
                subtitle = "서브타이틀",
                actions = {
                    TopBarButton {
                    }
                    TopBarButton {
                    }
                }
            )
            DoubleTitleTopBar(
                title = "타이틀",
                subtitle = "서브타이틀",
                actions = {
                    TopBarButton {
                    }
                }
            )
            DoubleTitleTopBar(
                subtitle = "서브타이틀",
                actions = {

                }
            )
            DoubleTitleTopBar(
                title = "타이틀",
                actions = {

                }
            )
            DoubleTitleTopBar(
                actions = {

                }
            )
        }
    }
}