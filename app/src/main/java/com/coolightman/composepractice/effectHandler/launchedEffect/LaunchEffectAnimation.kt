package com.coolightman.composepractice.effectHandler.launchedEffect

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

@Composable
fun LaunchEffectAnimation(
    counter: Int
) {
    val animatable = remember {
        Animatable(0f)
    }
//    its coroutine will be cancelled and re-launch every time when changes counter
    LaunchedEffect(key1 = counter){
        animatable.animateTo(counter.toFloat())
    }
}