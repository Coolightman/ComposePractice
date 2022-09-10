package com.coolightman.composepractice.effectHandler.sideEffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

@Composable
fun SideEffectDemo() {
    SideEffect {
        println("Called after every successful recomposition")
    }
}