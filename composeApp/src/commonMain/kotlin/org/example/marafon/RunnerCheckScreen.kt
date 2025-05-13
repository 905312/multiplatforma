package org.example.marafon

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun RunnerCheckScreen(navigator: Navigator) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MARATHON SKILLS 2016",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Кнопка "Я участвовал ранее"
        Button(
            onClick = { navigator.navigateTo(Screen.LOGIN_MENU) },
            modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Я участвовал ранее",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Кнопка "Я новый участник"
        Button(
            onClick = { navigator.navigateTo(Screen.RUNNER_REGISTRATION) },
            modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Я новый участник",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Кнопка "Login" в правом нижнем углу
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(
                onClick = { navigator.navigateTo(Screen.LOGIN_MENU) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
            ) {
                Text("Login")
            }
        }
    }
}
