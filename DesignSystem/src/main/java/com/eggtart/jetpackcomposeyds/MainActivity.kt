package com.eggtart.jetpackcomposeyds

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.atom.BoxButton
import com.eggtart.jetpackcomposeyds.ui.theme.atom.Rounding
import com.eggtart.jetpackcomposeyds.ui.theme.atom.Size
import com.eggtart.jetpackcomposeyds.ui.theme.atom.Type


class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val type = Type.TINTED
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
                        type = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        size = Size.EXTRA_LARGE,
                        rounding = Rounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = R.drawable.ic_ground_line,
                        type = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        size = Size.LARGE,
                        rounding = Rounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = R.drawable.ic_ground_line,
                        type = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        size = Size.MEDIUM,
                        rounding = Rounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = R.drawable.ic_ground_line,
                        type = type,
                        isDisabled = isDisabled,
                        isWarned = isWarned,
                        size = Size.SMALL,
                        rounding = Rounding.EIGHT
                    )
                }
            }
        }
    }
}


