package com.eggtart.jetpackcomposeyds.ui.theme.component.tooltip

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme

// ImageVector를 쓸지 Shape을 쓸지.... ex. SquircleShape
// 아래를 바라보는 방향이다. 돌려야 한다.
val TAIL: ImageVector
    get() {
        if (_TAIL != null) {
            return _TAIL!!
        }
        _TAIL = ImageVector.Builder(
            name = "TAIL",
            defaultWidth = 28.0.dp,
            defaultHeight = 9.0.dp,
            viewportWidth = 28.0F,
            viewportHeight = 9.0F,
        ).path(
            fill = SolidColor(Color(0xFF816DEC)),
            fillAlpha = 1.0F,
            strokeAlpha = 1.0F,
            strokeLineWidth = 0.0F,
            strokeLineCap = StrokeCap.Butt,
            strokeLineJoin = StrokeJoin.Miter,
            strokeLineMiter = 4.0F,
            pathFillType = PathFillType.NonZero,
        ) {
            moveTo(12.5858F, 8.4252F)
            lineTo(6.3432F, 2.2993F)
            curveTo(4.8429F, 0.8271F, 2.808F, 0.0F, 0.6863F, 0.0F)
            horizontalLineTo(27.3137F)
            curveTo(25.192F, 0.0F, 23.1571F, 0.8271F, 21.6569F, 2.2993F)
            lineTo(15.4142F, 8.4252F)
            curveTo(14.6332F, 9.1916F, 13.3668F, 9.1916F, 12.5858F, 8.4252F)
            close()
        }.build()
        return _TAIL!!
    }
private var _TAIL: ImageVector? = null

@Preview
@Composable
@Suppress("UnusedPrivateMember")
private fun IconTAILPreview() {
    Image(
        imageVector = TAIL,
        contentDescription = null,
        colorFilter = ColorFilter.tint(Color.Red),
        modifier = Modifier
            .size(100.dp, 100.dp)
    )
}

fun Modifier.vertical() =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.height, placeable.width) {
            placeable.place(
                x = -(placeable.width / 2 - placeable.height / 2),
                y = -(placeable.height / 2 - placeable.width / 2)
            )
        }
    }

data class TooltipState(
    val message: String = ""
) {

    sealed interface TailPositions {
        object Start : TailPositions
        object Center : TailPositions
        object End : TailPositions
    }

    sealed interface TailDirections {
        object Top : TailDirections
        object Bottom : TailDirections
        object Start : TailDirections
        object End : TailDirections
    }

    fun asd(tailDirections: TailDirections) {
        when(tailDirections)  {
            TailDirections.Bottom -> TODO()
            TailDirections.End -> TODO()
            TailDirections.Start -> TODO()
            TailDirections.Top -> {

            }
        }
    }
}


@Composable
fun Tooltip(
    message: String = ""
) {
    Column {
        Image(
            imageVector = TAIL,
            contentDescription = null,
            colorFilter = ColorFilter.tint(YdsTheme.colors.tooltipBG),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterHorizontally)
                .rotate(180f)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                imageVector = TAIL,
                contentDescription = null,
                colorFilter = ColorFilter.tint(YdsTheme.colors.tooltipBG),
                modifier = Modifier
                    .vertical()
                    .rotate(90f)
            )
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(YdsTheme.colors.tooltipBG)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(
                    message,
                    maxLines = 1,
                    style = YdsTheme.typography.caption0,
                    color = YdsTheme.colors.textBright
                )
            }
            Image(
                imageVector = TAIL,
                contentDescription = null,
                colorFilter = ColorFilter.tint(YdsTheme.colors.tooltipBG),
                modifier = Modifier
                    .vertical()
                    .rotate(-90f)
            )
        }
        Image(
            imageVector = TAIL,
            contentDescription = null,
            colorFilter = ColorFilter.tint(YdsTheme.colors.tooltipBG),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}