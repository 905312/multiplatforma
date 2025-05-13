package org.example.marafon

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen as VoyagerScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator as VoyagerNavigator
import cafe.adriel.voyager.navigator.currentOrThrow


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


class MainScreenModel : ScreenModel {

}


object NavigationState {
    var navigator: Navigator? = null
    var voyagerNavigator: VoyagerNavigator? = null
}


class Navigator {
    val currentScreen = mutableStateOf(Screen.MAIN_SCREEN)
    val parameters = mutableStateOf<Map<String, Any>>(emptyMap())
    
    init {

        NavigationState.navigator = this
    }
    
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

// Navigation handler using Voyager
object NavigationHandler {
    private var parameters: Map<String, Any> = emptyMap()
    
    @Composable
    fun SetupNavigationHandler() {

        NavigationState.voyagerNavigator = LocalNavigator.currentOrThrow
        

        val classicNavigator = NavigationState.navigator
        if (classicNavigator != null) {
            val screen = classicNavigator.currentScreen.value
            

            LaunchedEffect(screen) {
                val params = classicNavigator.parameters.value
                val voyagerScreen = mapScreenToVoyager(screen, params)
                NavigationState.voyagerNavigator?.replace(voyagerScreen)
            }
        }
    }
    
    private fun mapScreenToVoyager(screen: Screen, params: Map<String, Any>): VoyagerScreen {
        return when(screen) {
            Screen.MAIN_SCREEN -> MainScreenVoyager
            Screen.RUNNER_CHECK -> RunnerCheckScreenVoyager
            Screen.LOGIN_MENU -> LoginMenuScreenVoyager
            Screen.RUNNER_REGISTRATION -> RunnerRegistrationScreenVoyager(params)
            Screen.EVENT_REGISTRATION -> EventRegistrationScreenVoyager(params)
            Screen.SPONSOR_RUNNER -> SponsorRunnerScreenVoyager(params)
            Screen.SPONSORSHIP_CONFIRMATION -> SponsorshipConfirmationScreenVoyager
            Screen.REGISTRATION_CONFIRMATION -> RegistrationConfirmationScreenVoyager
            Screen.RUNNER_MENU -> RunnerMenuScreenVoyager
            Screen.MORE_INFO -> MoreInfoScreenVoyager
            Screen.ABOUT_MARATHON -> AboutMarathonScreenVoyager
        }
    }
    
    @Composable
    fun getCurrentNavigator(): VoyagerNavigator {
        return LocalNavigator.currentOrThrow
    }
    
    fun getParameter(key: String) = parameters[key]
    
    fun getStringParameter(key: String, default: String = "") = 
        parameters[key]?.toString() ?: default
    
    fun getIntParameter(key: String, default: Int = 0) = 
        (parameters[key] as? Int) ?: default
    
    fun getScreenTitle(screen: VoyagerScreen) = when (screen) {
        is RunnerCheckScreenVoyager -> "Register as a runner"
        is LoginMenuScreenVoyager -> "Login"
        is RunnerRegistrationScreenVoyager -> "Register as a runner"
        is EventRegistrationScreenVoyager -> "Register for an event"
        is SponsorRunnerScreenVoyager -> "Sponsor a runner"
        is SponsorshipConfirmationScreenVoyager -> "Sponsorship confirmation"
        is RegistrationConfirmationScreenVoyager -> "Registration confirmation"
        is RunnerMenuScreenVoyager -> "Runner menu"
        is MoreInfoScreenVoyager -> "Find out more information"
        is AboutMarathonScreenVoyager -> "About Marathon Skills 2016"
        else -> "Marathon Skills 2016"
    }
}

// Screen interfaces for all app screens
object MainScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        // Использование ScreenModel для управления состоянием экрана
        val screenModel = rememberScreenModel { MainScreenModel() }
        
        // Обработка кнопки "назад"
        BackHandlerWithNavigator()
        
        // Используем существующий навигатор или создаем новый
        val navigator = NavigationState.navigator ?: rememberNavigator()
        
        org.example.marafon.MainScreen(navigator)
    }
}

object RunnerCheckScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.RunnerCheckScreen(navigator)
    }
}

object LoginMenuScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.LoginMenuScreen(navigator)
    }
}

data class RunnerRegistrationScreenVoyager(val params: Map<String, Any> = emptyMap()) : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.RunnerRegistrationScreen(navigator)
    }
}

data class EventRegistrationScreenVoyager(val params: Map<String, Any> = emptyMap()) : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.EventRegistrationScreen(navigator)
    }
}

data class SponsorRunnerScreenVoyager(val params: Map<String, Any> = emptyMap()) : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.SponsorRunnerScreen(navigator)
    }
}

object SponsorshipConfirmationScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.SponsorshipConfirmationScreen(navigator)
    }
}

object RegistrationConfirmationScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.RegistrationConfirmationScreen(navigator)
    }
}

object RunnerMenuScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.RunnerMenuScreen(navigator)
    }
}

object MoreInfoScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.MoreInfoScreen(navigator)
    }
}

object AboutMarathonScreenVoyager : VoyagerScreen {
    @Composable
    override fun Content() {
        BackHandlerWithNavigator()
        val navigator = NavigationState.navigator ?: rememberNavigator()
        org.example.marafon.AboutMarathonScreen(navigator)
    }
}


@Composable
fun BackHandlerWithNavigator() {

}

// Helper function to remember navigation handler
@Composable
fun rememberNavigator() = remember { Navigator() }
