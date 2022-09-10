package com.coolightman.composepractice.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun ColorBox(modifier: Modifier = Modifier) {
    var boxColor by remember {
        mutableStateOf(Color.Gray)
    }

    Box(
        modifier
            .background(boxColor)
            .height(100.dp)
            .width(100.dp)
            .clickable {
                boxColor = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }) {

    }
}

@Preview
@Composable
fun ColorBoxPreview() {
    ColorBox()
}