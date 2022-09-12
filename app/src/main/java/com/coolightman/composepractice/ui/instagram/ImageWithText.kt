package com.coolightman.composepractice.ui.instagram

data class ImageWithText(
    val text: String,
    val image: Int,
    val storiesStatus: StoriesStatus = StoriesStatus.Viewed()
)
