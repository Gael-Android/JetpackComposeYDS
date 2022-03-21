package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.black000A10

//@Preview
//@Composable
//fun Converter() {
//    JetpackComposeYDSTheme {
//        with(LocalDensity.current) {
//            Log.d("KWK-converter", 72.toDp().toString()) // 72 px == 26.181818 dp
//        }
//    }
//}

data class PickerState(
    val lazyListState: LazyListState,
    val itemList: List<String>,
) {
    val currentItemIndex = lazyListState.firstVisibleItemIndex
}

@Composable
fun rememberPickerState(
    lazyListState: LazyListState = rememberLazyListState(),
    itemList: List<String>
) = remember(lazyListState, itemList) {
    mutableStateOf(
        PickerState(
            lazyListState = lazyListState,
            itemList = itemList
        )
    )
}

@Composable
fun Picker(
    pickerState: PickerState
) {
    val lazyListState = pickerState.lazyListState

    val itemHeight = if (lazyListState.layoutInfo.visibleItemsInfo.isNotEmpty()) {
        lazyListState.layoutInfo.visibleItemsInfo[0].size // 72 px or 73 px
    } else {
        73
    }

    val itemHeightDp = with(LocalDensity.current) {
        itemHeight.toDp().value
    }

    LaunchedEffect(lazyListState.isScrollInProgress) {
        if (lazyListState.firstVisibleItemScrollOffset > (itemHeight / 2)) {
            lazyListState.animateScrollToItem(lazyListState.firstVisibleItemIndex + 1)
        } else {
            lazyListState.animateScrollToItem(lazyListState.firstVisibleItemIndex)
        }
    }

//        Text(text = "firstVisibleItemScrollOffset = ${state.firstVisibleItemScrollOffset}")
//        Text(text = "centerItemScrollOffset = ${state.firstVisibleItemScrollOffset}")
//        Text(text = "firstVisibleItemIndex = ${state.firstVisibleItemIndex - 3}")
//        Text(text = "centerItemIndex = ${state.firstVisibleItemIndex}")
//        Text(
//            text = "Info = $itemHeight"
//        )

    LazyColumn(
        modifier = Modifier
            .height((itemHeightDp * 7).dp)
            .background(YdsTheme.colors.dimThickBright)
            .drawWithContent {
                val width = drawContext.size.width
                val startFraction = 0f
                val endFraction = 1f

                drawContent()
                drawLine(
                    color = black000A10.copy(alpha = 0.9f),
                    start = Offset(
                        width * startFraction,
                        itemHeight * 3F,
                    ),
                    end = Offset(
                        width * endFraction,
                        itemHeight * 3F,
                    ),
                    strokeWidth = 0.34f
                )
                drawLine(
                    color = black000A10.copy(alpha = 0.9f),
                    start = Offset(
                        width * startFraction,
                        itemHeight * 4F,
                    ),
                    end = Offset(
                        width * endFraction,
                        itemHeight * 4F,
                    ),
                    strokeWidth = 0.34f
                )
            },
        state = lazyListState,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(3) {
            Spacer(
                modifier = Modifier
                    .height(itemHeightDp.dp)
                    .padding(vertical = 4.dp)
            )
        }
        itemsIndexed(pickerState.itemList) { index, item ->
            Text(
                item,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 4.dp),
                style = YdsTheme.typography.body1,
                color = if (index == lazyListState.firstVisibleItemIndex) {
                    YdsTheme.colors.textPrimary
                } else {
                    YdsTheme.colors.textDisabled
                }
            )
        }
        items(3) {
            Spacer(
                modifier = Modifier
                    .height(itemHeightDp.dp)
                    .padding(vertical = 4.dp)
            )
        }
    }


}

@Preview
@Composable
private fun PreviewPickerRow() {
    val picker1state by rememberPickerState(
        itemList = (1..100).map {
            it.toString()
        }.toList()
    )


    val picker2state by rememberPickerState(itemList = (1..100).map {
        it.toString()
    }.toList())

    val picker3state by rememberPickerState(itemList = (1..100).map {
        it.toString()
    }.toList())

    JetpackComposeYDSTheme {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Picker(picker1state)
            Picker(picker2state)
            Picker(picker3state)
        }
    }
}

@Preview
@Composable
private fun PreviewPicker() {
    val picker1state: PickerState by rememberPickerState(itemList = (1..100).map {
        it.toString()
    }.toList())

    JetpackComposeYDSTheme {
        Picker(picker1state)
    }
}
