package com.coolightman.composepractice.effectHandler.rememberCoroutineScope

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RememberCoroutineScopeDemo() {
    val scope = rememberCoroutineScope()

    Button(onClick = {
//        use it scope only in callbacks. Its call only one time for click
        scope.launch {
            delay(1000L)
            println("Hello Compose!")
        }
    }) {

    }

}