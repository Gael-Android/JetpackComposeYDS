package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
data class BottomSheetState(
    val modalBottomSheetState: ModalBottomSheetState = ModalBottomSheetState(ModalBottomSheetValue.Hidden),
) {
    suspend fun show() = modalBottomSheetState.show()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun rememberBottomSheetState(
    modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden
    ),
) = remember(modalBottomSheetState) {
    mutableStateOf(
        BottomSheetState(
            modalBottomSheetState = modalBottomSheetState,
        )
    )
}

@ExperimentalMaterialApi
@Composable
fun BottomSheet(
    bottomSheetState: BottomSheetState = rememberBottomSheetState().value,
    sheetContent: @Composable () -> Unit = @Composable {},
    content: @Composable () -> Unit = @Composable {},
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState.modalBottomSheetState,
        scrimColor = YdsTheme.colors.dimNormal,
        sheetContent = {
            Box(
                Modifier
                    .heightIn(
                        min = 88.dp,
                        max = LocalConfiguration.current.screenHeightDp.dp - 88.dp
                    )
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                sheetContent()
            }
        },
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetBackgroundColor = YdsTheme.colors.bgNormal
    ) {
        content()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
private fun Preview() {
    val state by rememberBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    JetpackComposeYDSTheme {
        BottomSheet(
            bottomSheetState = state,
            sheetContent = {
                Column {
                    repeat(10) {
                        Text(text = "$it hello world!")
                    }
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Rest of the UI")
                Spacer(Modifier.height(20.dp))
                Button(
                    onClick = {
                        coroutineScope.launch {
                            state.show()
                        }
                    }
                ) {
                    Text("Click to show sheet")
                }
            }
        }
    }
}