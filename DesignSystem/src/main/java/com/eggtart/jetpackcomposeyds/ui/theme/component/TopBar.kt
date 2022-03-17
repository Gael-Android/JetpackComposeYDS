package com.eggtart.jetpackcomposeyds.ui.theme.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme

@Composable
fun TopBar(
    title: String = "",
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        backgroundColor = YdsTheme.colors.bgElevated,
        contentColor = YdsTheme.colors.textPrimary,
        elevation = 0.dp,
        contentPadding = PaddingValues(horizontal = 4.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = CenterVertically, modifier = Modifier
                    .fillMaxHeight()
                    .align(TopStart)
                    .padding(0.dp)
            ) {
                navigationIcon()
            }

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(0.dp)
                    .align(TopCenter),
                verticalAlignment = CenterVertically,
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    text = title,
                    style = YdsTheme.typography.SubTitle2,
                    color = YdsTheme.colors.textPrimary
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(0.dp)
                    .align(TopEnd),
                verticalAlignment = CenterVertically
            ) {
                actions()
            }
        }
    }
}

@Preview
@Composable
fun PreviewTopBar() {
    JetpackComposeYDSTheme {
        Column {
            TopBar(
                title = "타이틀",
                navigationIcon = {
                    TopBarButton {

                    }
                },
                actions = {
                    TopBarButton {
                    }
                    TopBarButton {
                    }
                }
            )
            TopBar(
                title = "타이틀",
                navigationIcon = {
                    TopBarButton {
                    }
                },
                actions = {
                    TopBarButton {
                    }
                }
            )
            TopBar(
                title = "타이틀",
                navigationIcon = {
                    TopBarButton {
                    }
                },
                actions = {

                }
            )
            TopBar(
                title = "타이틀",
                navigationIcon = {

                },
                actions = {

                }
            )
            TopBar(
                navigationIcon = {

                },
                actions = {

                }
            )
        }
    }
}