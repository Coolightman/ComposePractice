package com.coolightman.composepractice.ui.elements

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAnimationHere() {
    var sizeState by remember {
        mutableStateOf(200.dp)
    }
    val size by animateDpAsState(
        targetValue = sizeState,
        tween(
            durationMillis = 500,
            delayMillis = 100,
            easing = FastOutSlowInEasing
        )
//                spring(
//                    Spring.DampingRatioMediumBouncy
//                )
//                keyframes {
//                    durationMillis = 3000
//                    sizeState at 0 with LinearEasing
//                    sizeState * 1.1f at 1500 with FastOutLinearInEasing
//                    sizeState * 1.5f at 3000
//                }
    )

    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.Gray,
        targetValue = Color.DarkGray,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(
        modifier = Modifier
            .size(size)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                sizeState += 50.dp
            }) {
                Text(text = "Increase Size")
            }

            Button(onClick = {
                sizeState = 200.dp
            }) {
                Text(text = "Default Size")
            }

            Button(onClick = {
                sizeState -= 50.dp
            }) {
                Text(text = "Decrease Size")
            }
        }
    }
}

@Preview
@Composable
private fun ItPreview() {
    SimpleAnimationHere()
}