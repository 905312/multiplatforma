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
import androidx.compose.ui.window.Dialog

@Composable
fun RunnerMenuScreen(navigator: Navigator) {
    var showContactDialog by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Меню бегуна",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        
        // Кнопка "Регистрация на марафон"
        Button(
            onClick = { navigator.navigateTo(Screen.EVENT_REGISTRATION) },
            modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Регистрация на марафон",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Кнопка "Редактировать профиль"
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Редактировать профиль",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Кнопка "Контакты"
        Button(
            onClick = { showContactDialog = true },
            modifier = Modifier.fillMaxWidth().height(80.dp).padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = "Контакты",
                style = MaterialTheme.typography.button,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
    }
    
    // Диалоговое окно контактов
    if (showContactDialog) {
        Dialog(onDismissRequest = { showContactDialog = false }) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Контакты",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    Text(
                        text = "Для получения дополнительной информации пожалуйста свяжитесь с координаторами",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    
                    Text(
                        text = "Телефон: +55 11 9988 7766",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                    )
                    
                    Text(
                        text = "Email: coordinators@marathonskills.org",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
                    )
                    
                    Button(
                        onClick = { showContactDialog = false },
                        modifier = Modifier.align(Alignment.End).padding(top = 8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                    ) {
                        Text("×", color = Color.White, fontSize = 20.sp)
                    }
                }
            }
        }
    }
}
