package com.coolightman.composepractice.ui.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PostTabSection(
    posts: List<Int>,
    modifier: Modifier = Modifier,
    userScrollEnabled: MutableState<Boolean>
) {
    val lazyGridState = rememberLazyGridState()
    LazyVerticalGrid(
        state = lazyGridState,
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        modifier = modifier,
        userScrollEnabled = userScrollEnabled.value
    ) {
        items(posts.size) {
            Image(
                painter = painterResource(id = posts[it]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 0.1.dp,
                        color = MaterialTheme.colors.onSecondary
                    )
            )
        }
    }
}