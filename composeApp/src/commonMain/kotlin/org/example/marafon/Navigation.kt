package org.example.marafon

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

enum class Screen {
    MAIN_SCREEN,
    RUNNER_CHECK,
    LOGIN_MENU,
    RUNNER_REGISTRATION,
    EVENT_REGISTRATION,
    SPONSOR_RUNNER,
    SPONSORSHIP_CONFIRMATION,
    REGISTRATION_CONFIRMATION,
    RUNNER_MENU,
    MORE_INFO,
    ABOUT_MARATHON
}

class Navigator {
    val currentScreen = mutableStateOf(Screen.MAIN_SCREEN)
    val parameters = mutableStateOf<Map<String, Any>>(emptyMap())
    
    fun navigateTo(screen: Screen, params: Map<String, Any> = emptyMap()) {
        currentScreen.value = screen
        parameters.value = params
    }
    
    fun getParameter(key: String) = parameters.value[key]
    
    fun getStringParameter(key: String, default: String = "") = 
        parameters.value[key]?.toString() ?: default
    
    fun getIntParameter(key: String, default: Int = 0) = 
        (parameters.value[key] as? Int) ?: default
    
    fun goBack() {
        currentScreen.value = when (currentScreen.value) {
            Screen.RUNNER_CHECK -> Screen.MAIN_SCREEN
            Screen.LOGIN_MENU -> Screen.RUNNER_CHECK
            Screen.RUNNER_REGISTRATION -> Screen.RUNNER_CHECK
            Screen.EVENT_REGISTRATION -> Screen.RUNNER_MENU
            Screen.SPONSOR_RUNNER -> Screen.MAIN_SCREEN
            Screen.SPONSORSHIP_CONFIRMATION -> Screen.SPONSOR_RUNNER
            Screen.REGISTRATION_CONFIRMATION -> Screen.RUNNER_REGISTRATION
            Screen.RUNNER_MENU -> Screen.LOGIN_MENU
            Screen.MORE_INFO -> Screen.MAIN_SCREEN
            Screen.ABOUT_MARATHON -> Screen.MORE_INFO
            else -> Screen.MAIN_SCREEN
        }
    }
}

@Composable
fun rememberNavigator() = remember { Navigator() }
