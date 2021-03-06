package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.rule.minWidth


sealed class Thickness(
    val width: Dp,
) {
    object Thin : Thickness(minWidth)
    object Thick : Thickness(8.dp)
}

sealed class Direction {
    object Horizontal : Direction()
    object Vertical : Direction()
}


@Composable
fun Divider(
    thickness: Thickness = Thickness.Thin,
    direction: Direction = Direction.Horizontal,
) {
    when (direction) {
        Direction.Horizontal -> {
            Divider(
                color = YdsTheme.colors.borderNormal,
                thickness = thickness.width
            )
        }
        Direction.Vertical -> {
            Divider(
                color = YdsTheme.colors.borderThin,
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
                thickness = Thickness.Thin,
                direction = Direction.Horizontal
            )

            Text("two", Modifier.padding(4.dp))

            // or replace it with a custom one
            Divider(
                thickness = Thickness.Thick,
                direction = Direction.Horizontal
            )

            Text("three", Modifier.padding(4.dp))
        }
    }
}

@Preview
@Composable
fun PreviewDividerVertical() {
    JetpackComposeYDSTheme {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Text("one", Modifier.padding(4.dp))

            // use the material divider
            Divider(
                thickness = Thickness.Thin,
                direction = Direction.Vertical
            )

            Text("two", Modifier.padding(4.dp))

            // or replace it with a custom one
            Divider(
                thickness = Thickness.Thick,
                direction = Direction.Vertical
            )

            Text("three", Modifier.padding(4.dp))
        }
    }
}

