package com.coolightman.composepractice.effectHandler.launchedEffect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class LaunchEffectViewModel: ViewModel() {

    private val _screenEvent = MutableSharedFlow<ScreenEvents>()
    val screenEvent = _screenEvent.asSharedFlow()

    init {
        viewModelScope.launch {
            _screenEvent.emit(ScreenEvents.ShowSnackbar("Hello Android!"))
        }
    }

    sealed class ScreenEvents{
        data class ShowSnackbar(val message: String): ScreenEvents()
        data class Navigate(val route: String): ScreenEvents()
    }
}