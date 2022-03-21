package com.eggtart.jetpackcomposeyds.ui.theme.component.top_bar

import androidx.compose.foundation.layout.*
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.atom.text_field.SearchTextField
import com.eggtart.jetpackcomposeyds.ui.theme.atom.text_field.SearchTextFieldState

@Composable
fun TopBar(
    searchTextFieldState: SearchTextFieldState,
    onValueChange: (String) -> Unit,
    onX: () -> Unit,
    onSearch: () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
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
                modifier = Modifier.fillMaxWidth()
            ) {
                navigationIcon()
                SearchTextField(
                    searchTextFieldState = searchTextFieldState,
                    onValueChange = onValueChange,
                    onX = onX
                ) {
                    onSearch()
                }
            }
        }
    }
}
