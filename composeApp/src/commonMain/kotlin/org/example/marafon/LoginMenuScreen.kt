package org.example.marafon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun LoginMenuScreen(navigator: Navigator) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showTestLoginDialog by remember { mutableStateOf(false) }
    
    var showEmailError by remember { mutableStateOf(false) }
    var showPasswordError by remember { mutableStateOf(false) }
    
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Форма авторизации",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 32.dp)
        )
        
        // Поле ввода email
        TextField(
            value = email,
            onValueChange = { 
                email = it 
                showEmailError = false
            },
            placeholder = { Text("Пожалуйста введите адрес электронной почты") },
            singleLine = true,
            isError = showEmailError,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Gray,
                unfocusedIndicatorColor = Color.LightGray,
                errorIndicatorColor = Color.Red
            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )
        
        if (showEmailError) {
            Text(
                "Введите адрес электронной почты",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        
        // Поле ввода пароля
        TextField(
            value = password,
            onValueChange = { 
                password = it 
                showPasswordError = false
            },
            placeholder = { Text("Пароль") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isError = showPasswordError,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Gray,
                unfocusedIndicatorColor = Color.LightGray,
                errorIndicatorColor = Color.Red
            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)
        )
        
        if (showPasswordError) {
            Text(
                "Введите пароль",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Кнопка Login
        Button(
            onClick = { 
                showEmailError = email.isEmpty()
                showPasswordError = password.isEmpty()
                if (!showEmailError && !showPasswordError) {
                    showTestLoginDialog = true
                }
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Login", color = Color.Black)
        }
    }
    
    // Диалоговое окно для тестирования
    if (showTestLoginDialog) {
        Dialog(onDismissRequest = { showTestLoginDialog = false }) {
            Box(
                modifier = Modifier.background(Color.White).padding(2.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .background(Color.White)
                        .padding(16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(Modifier.weight(1f))
                            Text(
                                text = "ТОЛЬКО ДЛЯ ТЕСТИРОВАНИЯ!",
                                color = Color(0xFFFFA500),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.weight(10f)
                            )
                            IconButton(
                                onClick = { showTestLoginDialog = false },
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    text = "×",
                                    color = Color.Red,
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Text(
                            text = "Под каким пользователем вы хотите войти в систему?",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        
                        // Кнопки выбора роли пользователя
                        Button(
                            onClick = { 
                                showTestLoginDialog = false
                                navigator.navigateTo(Screen.RUNNER_MENU)
                            },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            elevation = ButtonDefaults.elevation(defaultElevation = 1.dp),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text("Бегун", color = Color.DarkGray)
                        }
                        
                        Button(
                            onClick = { showTestLoginDialog = false },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            elevation = ButtonDefaults.elevation(defaultElevation = 1.dp),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text("Координатор", color = Color.DarkGray)
                        }
                        
                        Button(
                            onClick = { showTestLoginDialog = false },
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            elevation = ButtonDefaults.elevation(defaultElevation = 1.dp),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text("Администратор", color = Color.DarkGray)
                        }
                    }
                }
            }
        }
    }
}
