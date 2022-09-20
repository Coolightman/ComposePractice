package com.coolightman.composepractice.ui.instagram

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coolightman.composepractice.util.getHighlightsList

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<ImageWithText>
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(highlights.size) {
            val item = highlights[it]
            Column(
                modifier = Modifier.width(70.dp),
                horizontalAlignment = Alignment.CenterHorizontally
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

@Preview(
    widthDp = 320,
    showBackground = true
)
@Composable
private fun PreviewOf() {
    val highlightsList = getHighlightsList()
    HighlightSection(highlights = highlightsList)
}