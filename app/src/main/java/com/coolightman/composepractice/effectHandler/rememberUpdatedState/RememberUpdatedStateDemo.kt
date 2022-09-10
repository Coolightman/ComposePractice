package com.coolightman.composepractice.effectHandler.rememberUpdatedState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedStateDemo(
    onTimeout: () -> Unit
) {
//    if onTimeout change after first launch (before end of delay) it replace prev onTimeout out of re-launch
//    fo example: it needed if we use splash and change some operations until delay is continuous
    val updatedOnTimeout by rememberUpdatedState(newValue = onTimeout)
    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedOnTimeout()
    }
}