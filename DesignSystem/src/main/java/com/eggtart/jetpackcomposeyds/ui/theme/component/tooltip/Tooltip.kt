package com.eggtart.jetpackcomposeyds.ui.theme.component.tooltip

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme
import com.eggtart.jetpackcomposeyds.ui.theme.base.noRippleClickable
import kotlinx.coroutines.delay

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
    val message: String = "",
    val tailDirectionState: TailDirectionState = TailDirectionState.Bottom,
    val tailPositionState: TailPositionState = TailPositionState.Start,
    val backgroundColorState: BackgroundColorState = BackgroundColorState.ToolTipBG,
    val durationState: DurationState = DurationState.Medium,
) {
    val mutableTransitionState =
        MutableTransitionState(INVISIBLE)

    fun isVisible() = mutableTransitionState.run {
        isIdle && currentState
    }

    fun isInvisible() = mutableTransitionState.run {
        isIdle && !currentState
    }

    fun isDisappearing() = mutableTransitionState.run {
        !isIdle && currentState
    }

    fun isAppearing() = mutableTransitionState.run {
        !isIdle && !currentState
    }

    fun show() = mutableTransitionState.run {
        targetState = VISIBLE
    }

    fun hide() = mutableTransitionState.run {
        targetState = INVISIBLE
    }

    fun toggle() = mutableTransitionState.run {
        targetState = !targetState
    }

    sealed class BackgroundColorState {
        object ToolTipBG : BackgroundColorState()
        object ToolTipPoint : BackgroundColorState()

        @Composable
        fun color() = when (this) {
            ToolTipBG -> YdsTheme.colors.tooltipBG
            ToolTipPoint -> YdsTheme.colors.tooltipPoint
        }
    }

    sealed class DurationState(val millisecond: Int) {
        object Short : DurationState(1500)
        object Medium : DurationState(2500)
    }

    sealed class TailPositionState {
        object Start : TailPositionState()
        object Center : TailPositionState()
        object End : TailPositionState()
    }

    sealed class TailDirectionState {
        object Top : TailDirectionState()
        object Bottom : TailDirectionState()
        object Start : TailDirectionState()
        object End : TailDirectionState()
    }

    companion object {
        const val VISIBLE = true
        const val INVISIBLE = false
    }
}

@Composable
fun rememberTooltipState(
    message: String = "",
    tailDirectionState: TooltipState.TailDirectionState = TooltipState.TailDirectionState.Bottom,
    tailPositionState: TooltipState.TailPositionState = TooltipState.TailPositionState.Start,
    backgroundColorState: TooltipState.BackgroundColorState = TooltipState.BackgroundColorState.ToolTipBG,
    durationState: TooltipState.DurationState = TooltipState.DurationState.Medium,
) = remember(
    message, tailDirectionState, tailPositionState, backgroundColorState, durationState
) {
    mutableStateOf(
        TooltipState(
            message, tailDirectionState, tailPositionState, backgroundColorState, durationState
        )
    )
}

@Composable
fun Tooltip(
    tooltipState: TooltipState
) {
//    val state = remember {
//        MutableTransitionState(false).apply {
//            // Start the animation immediately.
////            targetState = true
//        }
//    }

    if (tooltipState.isVisible()) {
        LaunchedEffect(Unit) {
            delay(3000)
            tooltipState.hide()
        }
    }

    AnimatedVisibility(
        modifier = Modifier.offset(100.dp, 100.dp),
        visibleState = tooltipState.mutableTransitionState,
        enter = fadeIn(
            animationSpec = TweenSpec(
                durationMillis = tooltipState.durationState.millisecond,
                delay = 0,
                easing = CubicBezierEasing(0.25F, 0.1F, 0.25F, 1F)
            ),
            initialAlpha = 0F
        ),
        exit = fadeOut(
            animationSpec = TweenSpec(
                durationMillis = tooltipState.durationState.millisecond,
                delay = 0,
                easing = CubicBezierEasing(0.25F, 0.1F, 0.25F, 1F)
            ),
            targetAlpha = 0F
        )
    ) {
        Column {
            if (tooltipState.tailDirectionState == TooltipState.TailDirectionState.Top) {
                Image(
                    imageVector = TAIL,
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(YdsTheme.colors.tooltipBG),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterHorizontally)
                        .rotate(180f)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (tooltipState.tailDirectionState == TooltipState.TailDirectionState.Start) {
                    Image(
                        imageVector = TAIL,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(YdsTheme.colors.tooltipBG),
                        modifier = Modifier
                            .vertical()
                            .rotate(90f)
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(YdsTheme.colors.tooltipBG)
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Text(
                        tooltipState.message,
                        maxLines = 1,
                        style = YdsTheme.typography.caption0,
                        color = YdsTheme.colors.textBright
                    )
                }
                if (tooltipState.tailDirectionState == TooltipState.TailDirectionState.End) {
                    Image(
                        imageVector = TAIL,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(YdsTheme.colors.tooltipBG),
                        modifier = Modifier
                            .vertical()
                            .rotate(-90f)
                    )
                }
            }
            if (tooltipState.tailDirectionState == TooltipState.TailDirectionState.Bottom) {
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
    }
}

@Preview
@Composable
private fun Preview() {
    JetpackComposeYDSTheme {
        var state by rememberTooltipState(
            message = "홈에서 실시간 피드를 확인해보세요"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .noRippleClickable {
                    state.hide()
                }
        ) {
            Button(
                onClick = {
                    state.toggle()
                },
            ) {
                Text(
                    text = when {
                        state.isVisible() -> "Visible"
                        state.isDisappearing() -> "Disappearing"
                        state.isInvisible() -> "Invisible"
                        state.isAppearing() -> "Appearing"
                        else -> "Else"
                    }
                )
            }
            Text(
                text = "ㅁㄴㅇㅁㄴㅇㄹㄴㅇㅁ",
                modifier = Modifier
                    .offset(120.dp, 120.dp)
            )

            Tooltip(tooltipState = state)
        }
    }
}