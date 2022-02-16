package com.eggtart.jetpackcomposeyds.ui.theme.atom

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.eggtart.jetpackcomposeyds.R
import com.eggtart.jetpackcomposeyds.ui.theme.JetpackComposeYDSTheme
import com.eggtart.jetpackcomposeyds.ui.theme.YdsTheme


class SquircleShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawSquirclePath(size = size)
        )
    }

    private fun drawSquirclePath(size: Size): Path =
        Path().apply {
            val radius = size.width / 2
            val diameter = size.width
            val length = radius * 0.2f
            reset()

            lineTo(x = 0.0f, y = radius)
            cubicTo(
                x1 = 0.0f, y1 = length,
                x2 = length, y2 = 0.0f,
                x3 = radius, y3 = 0.0f,
            )

            lineTo(x = radius, y = 0.0f)
            cubicTo(
                x1 = diameter - length, y1 = 0.0f,
                x2 = diameter, y2 = length,
                x3 = diameter, y3 = radius,
            )

            lineTo(x = diameter, y = radius)
            cubicTo(
                x1 = diameter, y1 = diameter - length,
                x2 = diameter - length, y2 = diameter,
                x3 = radius, y3 = diameter,
            )

            lineTo(x = radius, y = diameter)
            cubicTo(
                x1 = length, y1 = diameter,
                x2 = 0.0f, y2 = diameter - length,
                x3 = 0.0f, y3 = radius,
            )

            close()
        }
}

sealed class ProfileImageViewSize(val dp: Dp) {
    object ExtraSmall : ProfileImageViewSize(32.dp)
    object Small : ProfileImageViewSize(36.dp)
    object Medium : ProfileImageViewSize(48.dp)
    object Large : ProfileImageViewSize(72.dp)
    object ExtraLarge : ProfileImageViewSize(96.dp)
}

@Composable
fun ProfileImageView(
    @DrawableRes image: Int? = null,
    size: ProfileImageViewSize = ProfileImageViewSize.ExtraLarge
) {
    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(id = image ?: R.drawable.my_profile_image),
        contentDescription = "my_profile_image",
        modifier = Modifier
            .size(size = size.dp)
            .border(
                width = YdsTheme.boarder.normal,
                color = YdsTheme.colors.borderNormal,
                shape = SquircleShape()
            )
            .graphicsLayer {
                shape = SquircleShape()
                clip = true
            }

    )
}

@Preview(
    showSystemUi = true,
)
@Composable
fun PreviewProfileImageView() {
    val profileImageViewSizeList = listOf(
        ProfileImageViewSize.ExtraLarge,
        ProfileImageViewSize.Large,
        ProfileImageViewSize.Medium,
        ProfileImageViewSize.Small,
        ProfileImageViewSize.ExtraSmall,
    )

    JetpackComposeYDSTheme {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in profileImageViewSizeList) {
                ProfileImageView(
                    size = i
                )
            }
        }
    }
}