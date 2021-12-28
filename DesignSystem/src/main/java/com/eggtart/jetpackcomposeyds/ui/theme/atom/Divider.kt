package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.BorderNormal
import com.eggtart.jetpackcomposeyds.ui.theme.foundation.BorderThin
import com.eggtart.jetpackcomposeyds.ui.theme.rule.minWidth


enum class Thickness(
    val width: Dp,
    val color: Color,
) {
    THIN(width = minWidth, color = BorderNormal),
    THICK(width = 8.dp, color = BorderThin),
}


enum class Direction {
    HORIZONTAL,
    VERTICAL
}


@Composable
fun Divider(
    thickness: Thickness = Thickness.THIN,
    direction: Direction = Direction.HORIZONTAL,
) {
    when (direction) {
        Direction.HORIZONTAL -> {
            Divider(
                color = thickness.color,
                thickness = thickness.width
            )
        }
        Direction.VERTICAL -> {
            Divider(
                color = thickness.color,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(thickness.width)
            )
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun PreviewDividerHorizontal() {
    JetpackComposeYDSTheme {
        Column(
            modifier = Modifier.width(IntrinsicSize.Max)
        ) {
            Text("one", Modifier.padding(4.dp))

            // use the material divider
            Divider(
                thickness = Thickness.THIN,
                direction = Direction.HORIZONTAL
            )

            Text("two", Modifier.padding(4.dp))

            // or replace it with a custom one
            Divider(
                thickness = Thickness.THICK,
                direction = Direction.HORIZONTAL
            )

            Text("three", Modifier.padding(4.dp))
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun PreviewDividerVertical() {
    JetpackComposeYDSTheme {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Text("one", Modifier.padding(4.dp))

            // use the material divider
            Divider(
                thickness = Thickness.THIN,
                direction = Direction.VERTICAL
            )

            Text("two", Modifier.padding(4.dp))

            // or replace it with a custom one
            Divider(
                thickness = Thickness.THICK,
                direction = Direction.VERTICAL
            )

            Text("three", Modifier.padding(4.dp))
        }
    }
}

