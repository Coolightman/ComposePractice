package com.coolightman.composepractice.util

import com.coolightman.composepractice.R
import com.coolightman.composepractice.ui.instagram.ImageWithText
import com.coolightman.composepractice.ui.instagram.StoriesStatus

fun getTabViewElements() = listOf(
    ImageWithText(
        image = R.drawable.ic_grid,
        text = "Posts"
    ),
    ImageWithText(
        image = R.drawable.reels,
        text = "Reels"
    ),
    ImageWithText(
        image = R.drawable.mention,
        text = "One more"
    )
)

fun getHighlightsList() = listOf(
    ImageWithText(
        image = R.drawable.hyena,
        text = "Hyena Story will begin"
    ),
    ImageWithText(
        image = R.drawable.rabbit,
        text = "Rabbit"
    ),
    ImageWithText(
        image = R.drawable.kermit,
        text = "Kermit",
        storiesStatus = StoriesStatus.Active()
    ),
    ImageWithText(
        image = R.drawable.hyena,
        text = "Hyena again",
        storiesStatus = StoriesStatus.Active()
    ),
    ImageWithText(
        image = R.drawable.kermit,
        text = "Kermit again"
    ),
    ImageWithText(
        image = R.drawable.rabbit,
        text = "One more"
    )
)

fun getPostList() = listOf(
    R.drawable.hyena,
    R.drawable.kermit,
    R.drawable.rabbit,
    R.drawable.rabbit,
    R.drawable.hyena,
    R.drawable.kermit,
    R.drawable.hyena,
    R.drawable.kermit,
    R.drawable.rabbit,
    R.drawable.kermit,
    R.drawable.hyena,
    R.drawable.kermit,
    R.drawable.rabbit,
    R.drawable.rabbit,
    R.drawable.hyena,
    R.drawable.kermit,
    R.drawable.hyena,
    R.drawable.kermit,
    R.drawable.rabbit,
    R.drawable.kermit
)