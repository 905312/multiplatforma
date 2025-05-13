package org.example.marafon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App() {
    val navigator = rememberNavigator()
    val marathonTheme = MaterialTheme.colors.copy(
        primary = Color(0xFF404040),
        primaryVariant = Color(0xFF303030),
        surface = Color(0xFFF0F0F0),
        background = Color.White
    )
    
    MaterialTheme(colors = marathonTheme) {
        val currentScreen = navigator.currentScreen.value
        
        Scaffold(
            topBar = { 
                MarathonTopBar(
                    showBackButton = currentScreen != Screen.MAIN_SCREEN, 
                    screenTitle = getScreenTitle(currentScreen),
                    onBackClick = { navigator.goBack() }
                )
            },
            bottomBar = { MarathonBottomBar() }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
                when (currentScreen) {
                    Screen.MAIN_SCREEN -> MainScreen(navigator)
                    Screen.RUNNER_CHECK -> RunnerCheckScreen(navigator)
                    Screen.LOGIN_MENU -> LoginMenuScreen(navigator)
                    Screen.RUNNER_REGISTRATION -> RunnerRegistrationScreen(navigator)
                    Screen.EVENT_REGISTRATION -> EventRegistrationScreen(navigator)
                    Screen.SPONSOR_RUNNER -> SponsorRunnerScreen(navigator)
                    Screen.SPONSORSHIP_CONFIRMATION -> SponsorshipConfirmationScreen(navigator)
                    Screen.REGISTRATION_CONFIRMATION -> RegistrationConfirmationScreen(navigator)
                    Screen.RUNNER_MENU -> RunnerMenuScreen(navigator)
                    Screen.MORE_INFO -> MoreInfoScreen(navigator)
                    Screen.ABOUT_MARATHON -> AboutMarathonScreen(navigator)
                }
            }
        }
    }
}

fun getScreenTitle(screen: Screen) = when (screen) {
    Screen.RUNNER_CHECK -> "Register as a runner"
    Screen.LOGIN_MENU -> "Login"
    Screen.RUNNER_REGISTRATION -> "Register as a runner"
    Screen.EVENT_REGISTRATION -> "Register for an event"
    Screen.SPONSOR_RUNNER -> "Sponsor a runner"
    Screen.SPONSORSHIP_CONFIRMATION -> "Sponsorship confirmation"
    Screen.REGISTRATION_CONFIRMATION -> "Registration confirmation"
    Screen.RUNNER_MENU -> "Runner menu"
    Screen.MORE_INFO -> "Find out more information"
    Screen.ABOUT_MARATHON -> "About Marathon Skills 2016"
    else -> "Marathon Skills 2016"
}

@Composable
fun MarathonTopBar(
    showBackButton: Boolean = false,
    screenTitle: String = "MARATHON SKILLS 2016",
    onBackClick: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth().background(Color(0xFF404040))) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBackButton) {
                Button(
                    onClick = onBackClick,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF303030)),
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text("Назад", color = Color.White)
                }
            }
            
            Text(
                text = "MARATHON SKILLS 2016",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            
            if (screenTitle.contains("Login", ignoreCase = true) || 
                screenTitle.contains("Registration", ignoreCase = true) ||
                screenTitle.contains("Runner menu", ignoreCase = true)) {
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF303030)),
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Text("Logout", color = Color.White)
                }
            }
        }
        
        if (!showBackButton) {
            Text(
                text = "Москва, Россия\nсреда 21 октября 2016",
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 8.dp)
            )
        }
    }
}

@Composable
fun MarathonBottomBar() {
    Box(
        modifier = Modifier.fillMaxWidth().background(Color(0xFF404040)).padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "18 дней 8 часов и 17 минут до старта марафона!",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}