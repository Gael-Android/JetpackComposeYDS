package com.eggtart.jetpackcomposeyds

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.atom.BoxButton
import com.eggtart.jetpackcomposeyds.ui.theme.atom.BoxButtonRounding
import com.eggtart.jetpackcomposeyds.ui.theme.atom.BoxButtonSize
import com.eggtart.jetpackcomposeyds.ui.theme.atom.BoxButtonType


class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val type = BoxButtonType.TINTED
            val isDisabled = false
            val isWarned = true


            JetpackComposeYDSTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = R.drawable.ic_ground_line,
                        boxButtonType = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        boxButtonSize = BoxButtonSize.EXTRA_LARGE,
                        rounding = BoxButtonRounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = R.drawable.ic_ground_line,
                        boxButtonType = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        boxButtonSize = BoxButtonSize.LARGE,
                        rounding = BoxButtonRounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = R.drawable.ic_ground_line,
                        boxButtonType = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        boxButtonSize = BoxButtonSize.MEDIUM,
                        rounding = BoxButtonRounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = R.drawable.ic_ground_line,
                        boxButtonType = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        boxButtonSize = BoxButtonSize.SMALL,
                        rounding = BoxButtonRounding.EIGHT
                    )
                }
            }
        }
    }
}


