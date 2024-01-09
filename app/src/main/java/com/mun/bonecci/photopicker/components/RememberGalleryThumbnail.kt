package com.mun.bonecci.photopicker.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
@Composable
fun rememberGalleryThumbnail(): ImageVector {
    return remember {
        ImageVector.Builder(
            name = "gallery_thumbnail",
            defaultWidth = 40.0.dp,
            defaultHeight = 40.0.dp,
            viewportWidth = 40.0f,
            viewportHeight = 40.0f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                fillAlpha = 1f,
                stroke = null,
                strokeAlpha = 1f,
                strokeLineWidth = 1.0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                strokeLineMiter = 1f,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(4.375f, 31.583f)
                quadToRelative(-1.083f, 0f, -1.854f, -0.771f)
                quadToRelative(-0.771f, -0.77f, -0.771f, -1.854f)
                verticalLineTo(11.042f)
                quadToRelative(0f, -1.084f, 0.771f, -1.875f)
                quadToRelative(0.771f, -0.792f, 1.854f, -0.792f)
                horizontalLineToRelative(17.917f)
                quadToRelative(1.083f, 0f, 1.875f, 0.792f)
                quadToRelative(0.791f, 0.791f, 0.791f, 1.875f)
                verticalLineToRelative(17.916f)
                quadToRelative(0f, 1.084f, -0.791f, 1.854f)
                quadToRelative(-0.792f, 0.771f, -1.875f, 0.771f)
                close()
                moveTo(30f, 18.25f)
                quadToRelative(-0.667f, 0f, -1.125f, -0.458f)
                quadToRelative(-0.458f, -0.459f, -0.458f, -1.125f)
                verticalLineTo(10f)
                quadToRelative(0f, -0.667f, 0.458f, -1.146f)
                quadToRelative(0.458f, -0.479f, 1.125f, -0.479f)
                horizontalLineToRelative(6.667f)
                quadToRelative(0.666f, 0f, 1.145f, 0.479f)
                quadToRelative(0.48f, 0.479f, 0.48f, 1.146f)
                verticalLineToRelative(6.667f)
                quadToRelative(0f, 0.666f, -0.48f, 1.125f)
                quadToRelative(-0.479f, 0.458f, -1.145f, 0.458f)
                close()
                moveToRelative(1.042f, -2.625f)
                horizontalLineToRelative(4.583f)
                verticalLineToRelative(-4.583f)
                horizontalLineToRelative(-4.583f)
                close()
                moveTo(4.375f, 28.958f)
                horizontalLineToRelative(17.917f)
                verticalLineTo(11.042f)
                horizontalLineTo(4.375f)
                verticalLineToRelative(17.916f)
                close()
                moveToRelative(3.75f, -4.041f)
                horizontalLineToRelative(10.417f)
                quadToRelative(0.375f, 0f, 0.562f, -0.355f)
                quadToRelative(0.188f, -0.354f, -0.021f, -0.687f)
                lineTo(16.167f, 20f)
                quadToRelative(-0.209f, -0.292f, -0.542f, -0.292f)
                quadToRelative(-0.333f, 0f, -0.542f, 0.292f)
                lineTo(12.5f, 23.458f)
                lineToRelative(-1.75f, -2.333f)
                quadToRelative(-0.208f, -0.292f, -0.542f, -0.292f)
                quadToRelative(-0.333f, 0f, -0.541f, 0.292f)
                lineToRelative(-2.042f, 2.75f)
                quadToRelative(-0.25f, 0.333f, -0.063f, 0.687f)
                quadToRelative(0.188f, 0.355f, 0.563f, 0.355f)
                close()
                moveTo(30f, 31.583f)
                quadToRelative(-0.667f, 0f, -1.125f, -0.458f)
                quadToRelative(-0.458f, -0.458f, -0.458f, -1.125f)
                verticalLineToRelative(-6.667f)
                quadToRelative(0f, -0.666f, 0.458f, -1.145f)
                quadToRelative(0.458f, -0.48f, 1.125f, -0.48f)
                horizontalLineToRelative(6.667f)
                quadToRelative(0.666f, 0f, 1.145f, 0.48f)
                quadToRelative(0.48f, 0.479f, 0.48f, 1.145f)
                verticalLineTo(30f)
                quadToRelative(0f, 0.667f, -0.48f, 1.125f)
                quadToRelative(-0.479f, 0.458f, -1.145f, 0.458f)
                close()
                moveToRelative(1.042f, -2.625f)
                horizontalLineToRelative(4.583f)
                verticalLineToRelative(-4.583f)
                horizontalLineToRelative(-4.583f)
                close()
                moveToRelative(-26.667f, 0f)
                verticalLineTo(11.042f)
                verticalLineToRelative(17.916f)
                close()
                moveToRelative(26.667f, -13.333f)
                verticalLineToRelative(-4.583f)
                verticalLineToRelative(4.583f)
                close()
                moveToRelative(0f, 13.333f)
                verticalLineToRelative(-4.583f)
                verticalLineToRelative(4.583f)
                close()
            }
        }.build()
    }
}