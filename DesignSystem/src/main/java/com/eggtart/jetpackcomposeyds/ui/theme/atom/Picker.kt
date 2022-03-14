package com.eggtart.jetpackcomposeyds.ui.theme.atom

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.Black000A10

@Preview
@Composable
fun Converter() {
    JetpackComposeYDSTheme {
        with(LocalDensity.current) {
            Log.d("KWK-converter", 72.toDp().toString()) // 72 px == 26.181818 dp
        }
    }
}

@Preview
@Composable
fun ScrollBoxes() {
    JetpackComposeYDSTheme {
        val state = rememberLazyListState()

        val itemList = (0..3).toList()

//        LaunchedEffect(Unit) {
//            delay(3000)
//            state.animateScrollToItem(0)
//            delay(3000)
//            state.animateScrollToItem(10)
//            delay(3000)
//            state.animateScrollToItem(40)
//        }

        LaunchedEffect(state.isScrollInProgress) {
            if (state.firstVisibleItemScrollOffset > (72 / 2)) {
                state.animateScrollToItem(state.firstVisibleItemIndex + 1)
            } else {
                state.animateScrollToItem(state.firstVisibleItemIndex)
            }
        }

        Column {
            Text(text = "firstVisibleItemScrollOffset = ${state.firstVisibleItemScrollOffset}")
            Text(text = "centerItemScrollOffset = ${state.firstVisibleItemScrollOffset}")
            Text(text = "firstVisibleItemIndex = ${state.firstVisibleItemIndex - 3}")
            Text(text = "centerItemIndex = ${state.firstVisibleItemIndex}")
            Text(
                text = "Info = ${
                    if (state.layoutInfo.visibleItemsInfo.isNotEmpty()) {
                        state.layoutInfo.visibleItemsInfo[0].size // 72 px or 73 px
                    } else {
                        "???"
                    }
                }"
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((26 * 7).dp)
                    .background(YdsTheme.colors.dimThickReversed)
                    .padding(horizontal = 8.dp)
                    .drawWithContent {
                        val width = drawContext.size.width
                        val startFraction = 0f
                        val endFraction = 1f

                        drawContent()
                        drawLine(
                            color = Black000A10.copy(alpha = 0.9f),
                            start = Offset(
                                width * startFraction,
                                72 * 3F,
                            ),
                            end = Offset(
                                width * endFraction,
                                72 * 3F,
                            ),
                            strokeWidth = 0.34f
                        )
                        drawLine(
                            color = Black000A10.copy(alpha = 0.9f),
                            start = Offset(
                                width * startFraction,
                                72 * 4F,
                            ),
                            end = Offset(
                                width * endFraction,
                                72 * 4F,
                            ),
                            strokeWidth = 0.34f
                        )
                    }
                    .border(width = 1.dp, color = Color.Red),
                state = state,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(3) {
                    Spacer(
                        modifier = Modifier
                            .height(26.dp)
                            .width(10.dp)
                            .padding(vertical = 4.dp)
                    )
                }
                itemsIndexed(itemList) { index, item ->
                    Text(
                        "Item $index",
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 4.dp),
                        style = YdsTheme.typography.Body1,
                        color = if (index == state.firstVisibleItemIndex) {
                            YdsTheme.colors.textPrimary
                        } else {
                            YdsTheme.colors.textDisabled
                        }
                    )
                }
                items(3) {
                    Spacer(
                        modifier = Modifier
                            .height(26.dp)
                            .width(10.dp)
                            .padding(vertical = 4.dp)
                    )
                }
            }

        }
    }
}
