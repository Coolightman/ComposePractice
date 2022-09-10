package com.coolightman.composepractice.ui.instagram

import androidx.compose.ui.graphics.painter.Painter

data class ImageWithText(
    val text: String,
    val image: Painter,
    val storiesStatus: StoriesStatus = StoriesStatus.Viewed()
)
