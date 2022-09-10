package com.coolightman.composepractice.ui.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.coolightman.composepractice.ui.theme.RedInst
import com.coolightman.composepractice.ui.theme.VioletInst
import com.coolightman.composepractice.ui.theme.YellowInst


@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier,
    storiesStatus: StoriesStatus = StoriesStatus.Viewed()
) {
    val borderColor = MaterialTheme.colors.onSecondary
    val firstBorderWidth = 0.2.dp
    val borderModifier: Modifier = when (storiesStatus) {
        is StoriesStatus.None -> {
            modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = firstBorderWidth,
                    color = borderColor,
                    shape = CircleShape
                )
                .clip(CircleShape)
        }
        is StoriesStatus.Active -> {
            modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            YellowInst,
                            RedInst,
                            VioletInst
                        ),
                        start = Offset(0f, Float.POSITIVE_INFINITY),
                        end = Offset(Float.POSITIVE_INFINITY, 0f)
                    ),
                    shape = CircleShape
                )
                .padding(4.dp)
                .border(
                    width = firstBorderWidth,
                    color = borderColor,
                    shape = CircleShape
                )
                .clip(CircleShape)
        }
        is StoriesStatus.Viewed -> {
            modifier
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 0.8.dp,
                    color = borderColor,
                    shape = CircleShape
                )
                .padding(4.dp)
                .border(
                    width = firstBorderWidth,
                    color = borderColor,
                    shape = CircleShape
                )
                .clip(CircleShape)
        }
    }

    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = borderModifier
    )
}

sealed class StoriesStatus() {
    class None() : StoriesStatus()
    class Active() : StoriesStatus()
    class Viewed() : StoriesStatus()
}