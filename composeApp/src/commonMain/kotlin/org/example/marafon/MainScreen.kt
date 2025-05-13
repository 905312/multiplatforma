package org.example.marafon

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(navigator: Navigator) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainButton(
            text = "Я хочу стать бегуном",
            onClick = { navigator.navigateTo(Screen.RUNNER_CHECK) }
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        MainButton(
            text = "Я хочу стать спонсором бегуна",
            onClick = { navigator.navigateTo(Screen.SPONSOR_RUNNER) }
        )
        
        Spacer(modifier = Modifier.height(12.dp))
        
        MainButton(
            text = "Я хочу узнать больше о событии",
            onClick = { navigator.navigateTo(Screen.MORE_INFO) }
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            TextButton(
                onClick = { navigator.navigateTo(Screen.LOGIN_MENU) },
                colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colors.primary)
            ) {
                Text("Login")
            }
        }
    }
}

@Composable
private fun MainButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth().height(70.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 2.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.button,
            textAlign = TextAlign.Center,
            color = Color.DarkGray
        )
    }
}
