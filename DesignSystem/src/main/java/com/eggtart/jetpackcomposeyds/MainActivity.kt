package com.eggtart.jetpackcomposeyds

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
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
            JetpackComposeYDSTheme {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Button(onClick = { Log.d("KWK_","1123")}) {
                        Text(text = "asd")
                    }
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = null,
                        type = Type.FILLED,
                        isDisabled = false,
                        isWarned = false,
                        size = Size.EXTRA_LARGE,
                        rounding = Rounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = null,
                        type = Type.FILLED,
                        isDisabled = true,
                        isWarned = false,
                        size = Size.EXTRA_LARGE,
                        rounding = Rounding.EIGHT
                    )
                    BoxButton(
                        text = "what a nice world!",
                        leftIcon = R.drawable.ic_ground_line,
                        rightIcon = null,
                        type = Type.FILLED,
                        isDisabled = true,
                        isWarned = false,
                        size = Size.EXTRA_LARGE,
                        rounding = Rounding.EIGHT
                    )
                }
            }
        }
    }
}


