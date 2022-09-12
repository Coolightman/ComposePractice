package com.coolightman.composepractice.ui.instagram

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(highlights.size) {
            val item = highlights[it]
            val paddingModifier = if (it == highlights.size - 1) Modifier.padding(horizontal = 18.dp)
            else Modifier.padding(start = 18.dp)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = paddingModifier.width(70.dp)
            ) {
                RoundImage(
                    image = painterResource(id = item.image),
                    modifier = Modifier.size(70.dp),
                    storiesStatus = item.storiesStatus
                )
                Text(
                    text = item.text,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp
                )
            }
        }
    }
}