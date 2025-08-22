package com.example.arithmeticdrills

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.data.manager.LocalUserManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val localUserManager: LocalUserManager
): ViewModel() {
   private var _splashCondition by mutableStateOf(true)
    val splashCondition: Boolean get() = _splashCondition

    init {
        hideSplashScreen()
    }

    val hasSeenOnboarding: StateFlow<Boolean?> = localUserManager.readAppEntry()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun saveAppEntry() {
        viewModelScope.launch {
            localUserManager.saveAppEntry()
        }
    }

    fun hideSplashScreen(){
        viewModelScope.launch {
            delay(1000)
            _splashCondition = false
        }
    }
}