package com.coolightman.composepractice.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun <T> MyLazyList(list: List<T>) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(list) { index, item ->
            Text(
                text = "El ${item.toString()} in place $index",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyLazyListPreview() {
    val list = (50..100).toList()
    MyLazyList(list = list)
}