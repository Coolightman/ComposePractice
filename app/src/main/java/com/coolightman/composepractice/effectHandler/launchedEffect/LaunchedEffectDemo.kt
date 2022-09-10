package com.coolightman.composepractice.effectHandler.launchedEffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun LaunchedEffectDemo(
    viewModel: LaunchEffectViewModel
) {
//    its coroutine will be launch only once
    LaunchedEffect(key1 = true) {
        viewModel.screenEvent.collect { event ->
            when (event) {
                is LaunchEffectViewModel.ScreenEvents.ShowSnackbar -> {

                }
                is LaunchEffectViewModel.ScreenEvents.Navigate -> {

                }
            }
        }
    }
}